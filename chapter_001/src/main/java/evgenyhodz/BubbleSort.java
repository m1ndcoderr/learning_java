package evgenyhodz;

/**
 * Class with bubble method sorting.
 */
public class BubbleSort {

    /**
     * Method sort cells of int[] array with bubble sort way.
     *
     * @param array - array we are going to sort.
     */
    public void sort(int[] array) {
        int n = array.length;

        for (int k = 0; k < n - 1; k++) {
            for (int i = 0; i < n - k - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
}