package evgenyhodz;

/**
 * Class contains method to merge two sorted arrays.
 */
public class MergeArray {
    /**
     * Method for merging two sorted arrays.
     *
     * @param a - first sorted array.
     * @param b - second sorted array.
     * @return - third sorted array of that two.
     */
    public int[] merge(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                answer[k] = a[i];
                i++;
            } else {
                answer[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            answer[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            answer[k] = b[j];
            j++;
            k++;
        }
        return answer;
    }
}