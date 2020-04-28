package softeng250;

public class Main {
    public static void main(String[] args) {
        String[] applicants = {"Alice", "Bob", "Cathy", "David", "Emily"};
        String[] companies = {"Auckland", "Balfour", "Charlton", "Dipton", "Ettrick"};
        int[][] applicantPrefs = {
                {4, 0, 1, 3, 2},
                {2, 1, 3, 0, 4},
                {1, 2, 3, 4, 0},
                {0, 4, 3, 2, 1},
                {3, 1, 4, 2, 0}
        };
        int[][] companyPrefs = {
                {1, 0, 3, 4, 2},
                {3, 1, 0, 2, 4},
                {1, 4, 2, 3, 0},
                {0, 3, 2, 1, 4},
                {1, 3, 0, 4, 2}
        };

        StableMatching stableMatching = new StableMatching(applicants, companies, applicantPrefs, companyPrefs);
        stableMatching.performMatching();

        System.out.println("For the companies:");
        for (int i = 0; i < companies.length; i++) {
            int applicant = stableMatching._currentCompanyPairs[i];
            System.out.println("(" + companies[i] + ", " + applicants[applicant] + ")");
        }
        System.out.println();
        System.out.println("For the applicants:");
        for (int i = 0; i < applicants.length; i++) {
            int company = stableMatching._currentApplicantPairs[i];
            System.out.println("(" + applicants[i] + ", " + companies[company] + ")");
        }
    }
}
