package ru.evgenyhodz.itconverter;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.03.2017
 */
public class IteratorOfOneDimArray {

    private int[] values;

    private int move = 0;

    public IteratorOfOneDimArray(int[] data) {
        this.values = data;
    }

    public boolean hasNext() {
        return move + 1 > values.length;
    }

    public int next() {
        return values[move++];
    }

    /**
     * Не стал делать тест, решил продемонстрировать работу в мэйн :)
     *
     * @param args ---
     */
    public static void main(String[] args) {
        IteratorOfOneDimArray it = new IteratorOfOneDimArray(new int[]{1, 2, 3, 4});
        while (!it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
