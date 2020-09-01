package homework;

public class DynamicIntegerArrayImpl implements DynamicIntegerArray {

    private final int MINIMUM_SIZE = 5;
    private final double SIZE_MULTIPLIER = 1.5;

    private int[] array = new int[MINIMUM_SIZE];
    private int curSize;

    @Override
    public int get(int index) {
        if (index < 0 || index > curSize - 1)
            throw new IllegalArgumentException("Index out of bounds!");

        return array[index];
    }

    @Override
    public void add(int value) {
        if (curSize == array.length) {
            int newSize = (int) (curSize * SIZE_MULTIPLIER);
            int[] tmpArray = new int[newSize];
            System.arraycopy(array, 0, tmpArray, 0, array.length);
            array = tmpArray;
        }
        array[curSize++] = value;
    }

    @Override
    public int size() {
        return curSize;
    }
}