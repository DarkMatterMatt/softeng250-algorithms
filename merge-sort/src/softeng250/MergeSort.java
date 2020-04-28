package softeng250;

public class MergeSort {
    public int[] _result;
    private final int[] _data;

    MergeSort(int[] data, int start, int end) {
        _data = data;
        _result = new int[_data.length];

        mergeSort(start, end);
    }

    void mergeSort(int start, int end) {
        // check if the list has one element
        if (start == end) {
            return;
        }
        // we know there are at least two elements

        // I do this calculation slightly differently to Alex. I calculate the actual mid-point,
        //   Alex calculates the number of elements from the start to the mid-point.
        int mid = start + ((end - start) / 2);

        // sort the left and right sub-lists
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        // merge the sorted sub-lists
        merge(start, mid, mid + 1, end);
    }

    void merge(int start1, int end1, int start2, int end2) {
        int index1 = start1;
        int index2 = start2;
        int resultIndex = start1;

        // merge the two sub-lists
        while (index1 <= end1 && index2 <= end2) {
            // check if the element at index1 is smaller than the element at index2
            if (_data[index1] <= _data[index2]) {
                _result[resultIndex] = _data[index1];
                index1++;
                resultIndex++;
            }
            // the element at index2 is smaller than the element at index1
            else {
                _result[resultIndex] = _data[index2];
                index2++;
                resultIndex++;
            }
        }

        // put remaining items from the first list into the result array
        while (index1 <= end1) {
            _result[resultIndex] = _data[index1];
            index1++;
            resultIndex++;
        }
        // put remaining items from the second list into the result array
        while (index2 <= end2) {
            _result[resultIndex] = _data[index2];
            index2++;
            resultIndex++;
        }

        // copy the result back into the data array, we could just leave it in the result array...
        for (int i = start1; i <= end2; i++) {
            _data[i] = _result[i];
        }
    }
}
