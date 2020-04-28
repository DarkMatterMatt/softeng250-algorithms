package softeng250;

public class Main {
    public static void main(String[] args) {
        int[] data = {48, 36, 16, 10, 5, 15, 24, 8, 24, 6};

        if (data.length > 0) {
            MergeSort mergeSort = new MergeSort(data, 0, data.length - 1);

            System.out.println("Sorted array (using the original, modified, data array)");
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            System.out.println("Sorted array (using the mergeSort._result array)");
            for (int i = 0; i < mergeSort._result.length; i++) {
                System.out.print(mergeSort._result[i] + " ");
            }
        }
    }
}
