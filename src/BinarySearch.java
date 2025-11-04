class BinarySearch<T> {
    private T binaryNumber;
    BinarySearch(T a) {
        this.binaryNumber = a;
    }
    public T getNumber() {
        return this.binaryNumber;
    }

    public final static int binarySearch(int[] array, int key) {
        int L0 = 0, Hi = array.length - 1;

        while(L0 <= Hi) {
            int mid = L0 + (Hi - L0) / 2;
            if (key > array[mid]) L0 = mid + 1;
            else if (key < array[mid]) Hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}
class Second<T, S extends Number> extends BinarySearch<T> {
    private S money;
    Second(T a, S b) {
        super(a);
        this.money = b;
    }
    public S getMoney() {
        return this.money;
    }
    public double getCash(Second <? super Integer, ? extends Number> second) {
        Number amount = second.getMoney();
        System.out.println("Amount of money in double: " + amount.doubleValue());
        return amount.doubleValue();
    }
}
