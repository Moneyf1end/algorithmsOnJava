public final class BinaryHeap<T extends Comparable<T>> {
    private final int capacity;
    private int N;
    private T[] array; ;

    public int getN() {
        return N;
    }


    @SuppressWarnings("unchecked")
    BinaryHeap(T[] arrayFromInput) {
        this.capacity = arrayFromInput.length + 1;
        this.N = arrayFromInput.length;
        this.array = (T[]) new Comparable[this.capacity];
        for (int i = 0; i < this.N; i++) {
            this.array[i + 1] = arrayFromInput[i];
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(T elem) {
        if (N == array.length - 1) resize(array.length * 2);
        this.array[++N] = elem;
        swim(N);
    }
    public void showInfo() {
        for (T item : array) {
            System.out.print(item + "---");
        };
        System.out.println(" ");
    }

    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Comparable[newCapacity];
        for (int i = 1; i <= N; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }
    public void swim(int k) {
        while (k > 1) {
            int child = k;
            int parent = child / 2;
            if (!less(parent, child)) break;
            exchange(parent, child);
            k = parent;
        }
    }
    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }
    public T delMax() {
//        T endNode = array[N];
        T max = array[1];
        exchange(1, N--);
        array[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean less(int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }
    public void exchange(int i, int j) {
        T item = array[i];
        array[i] = array[j];
        array[j] = item;
    }
}