package softeng250;

import java.util.Arrays;
import java.util.LinkedList;

public class StableMatching {
    private final String[] _applicants;     // the input of applicants
    private final String[] _companies;      // the input of companies
    private final int[][] _applicantPrefs;  // the input of applicant preferences
    private final int[][] _companyPrefs;    // the input of company preferences

    public int[] _currentApplicantPairs;   // internship pairs from the view of applicants
    public int[] _currentCompanyPairs;     // internship pairs from the view of companies

    StableMatching(String[] applicants, String[] companies, int[][] applicantPrefs, int[][] companyPrefs) {
        _applicants = applicants;
        _companies = companies;
        _applicantPrefs = applicantPrefs;
        _companyPrefs = companyPrefs;

        _currentApplicantPairs = new int[_applicants.length];
        _currentCompanyPairs = new int[_companies.length];

        // -1 represents free because the company index starts from 0
        Arrays.fill(_currentApplicantPairs, -1);
        Arrays.fill(_currentCompanyPairs, -1);
    }

    public void performMatching() {
        LinkedList<Integer> free = new LinkedList<>(); // the free company list
        for (int i = 0; i < _companies.length; i++) {
            free.addLast(i);
        }

        // companies' next preference, at the start all are set to the zeroth index
        int[] next = new int[_applicants.length];

        int[][] rank = new int[_applicants.length][_companies.length];

        // rank is set based on the preference priority of each applicant
        for (int i = 0; i < _applicants.length; i++) {
            for (int j = 0; j < _companies.length; j++) {
                // the i'th applicant's j'th preference
                int company = _applicantPrefs[i][j];
                rank[company][i] = j;
            }
        }

        while (!free.isEmpty()) {
            // take the first company from the free company list
            int company = free.getFirst();

            // take the next applicant with the current highest priority for the company
            int nextApplicantIndex = next[company];
            int applicant = _companyPrefs[company][nextApplicantIndex];
            next[company]++; // next time we will take the next applicant

            // check if the applicant is free
            if (_currentApplicantPairs[applicant] == -1) {
                // save the internship pair
                _currentApplicantPairs[applicant] = company;
                _currentCompanyPairs[company] = applicant;

                // remove company from the free company list
                free.removeFirst();
            }
            // the applicant is not free, and will compare their preference
            //   priority by visiting the two-dimension rank array
            else {
                int currentCompany = _currentApplicantPairs[applicant];

                // check if the applicant will change internship
                if (rank[company][applicant] < rank[currentCompany][applicant]) {
                    // save the internship pair
                    _currentApplicantPairs[applicant] = company;
                    _currentCompanyPairs[company] = applicant;

                    // remove new company from the free company list, and add the old company to the free list
                    free.removeFirst();
                    free.addFirst(currentCompany);
                }
            }
        }
    }
}
