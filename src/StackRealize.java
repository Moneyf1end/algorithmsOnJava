public class StackRealize<T> {
    private T[] array;
    private int N = 0;


    StackRealize() {
        array = (T[]) new Object[10];
    }
    StackRealize(int capacity) {
        array = (T[]) new Object[capacity];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isFull() {
        return N == array.length;
    }
    public void push(T item) {
        if (isFull()) resize(2 * array.length);
        array[N++] = item;
    }
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        T elem = array[--N];
        array[N] = null;
        if (N > 0 && N == array.length / 4) resize(array.length / 2);
        return elem;
    }
    public void resize(int newCapacity) {
        T[] copyArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < N; i++) {
            copyArray[i] = array[i];
        }
        array = copyArray;
    }
    public T peek() {
        return array[N - 1];
    }
}
