package evgenyhodz;

/**
 * Class with method to check if substring is a part of origin string.
 */
public class CheckSubstring {
    /**
     * Check if substring is a part of origin string.
     *
     * @param origin - string value.
     * @param sub    - string value.
     * @return - boolean.
     */
    public boolean contains(String origin, String sub) {
        boolean result = false;
        int count;
        char[] originToCh = origin.toCharArray();
        char[] subToCh = sub.toCharArray();
        if (origin.length() >= sub.length()) {
            for (int q = 0; q <= originToCh.length - subToCh.length; q++) {
                count = 0;
                for (int z = q; z < q + subToCh.length; z++) {
                    if (originToCh[z] == subToCh[z - q]) {
                        count++;
                    }
                }
                result = count == subToCh.length;
            }
        }
        return result;
    }
}