package evgenyhodz;

/**
 * Remove duplicates from array of string.
 */
public class RemoveDuplicates {
    /**
     * Method removing duplicates from array of strings.
     *
     * @param array - array to do manipulations with.
     * @return - clean array.
     */
    public String[] rmDuplicates(String[] array) {
        int count = 0;
        for (int x = 0; x < array.length - 1; x++) {
            for (int y = x + 1; y < array.length; y++) {
                if (array[x] != null && array[x].equals(array[y])) {
                    array[y] = null;
                    count++;
                }
            }
        }
        String[] cleanArr = new String[array.length - count];
        int index = 0;
        for (String str : array) {
            if (str != null) {
                cleanArr[index] = str;
                index++;
            }
        }
        return cleanArr;
    }
}