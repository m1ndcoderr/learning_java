package evgenyhodz;

import java.util.Arrays;

/**
 * Class contains some (wrong!!!) ways to merge two arrays to one. And when sort it.
 */
public class WonderfulArray {

    /**
     * First way of merging.
     *
     * @param a - first array.
     * @param b - second array.
     * @return - third sorted array.
     */
    public int[] connectionOfArrs(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int u = 0;
        for (int x : a) {
            c[u] = x;
            u++;
        }
        for (int x : b) {
            c[u] = x;
            u++;
        }
        int n = c.length;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (c[j - 1] > c[j]) {
                    tmp = c[j - 1];
                    c[j - 1] = c[j];
                    c[j] = tmp;
                }
            }
        }
        return c;
    }

    /**
     * Second way of merging.
     *
     * @param a - first array.
     * @param b - second array.
     * @return - third sorted array.
     */
    public int[] connectionShortWay(int[] a, int[] b) {
        int[] fast = new int[a.length + b.length];
        int y = 0;
        for (int x : a) {
            fast[y] = x;
            y++;
        }
        for (int x : b) {
            fast[y] = x;
            y++;
        }
        Arrays.sort(fast);
        return fast;

    }

    /**
     * Third way of merging.
     *
     * @param a - first array.
     * @param b - second array.
     * @return - third sorted array.
     */
    public int[] concatArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        Arrays.sort(c);
        return c;
    }
}					