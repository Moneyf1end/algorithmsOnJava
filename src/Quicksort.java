import java.util.Arrays;
import java.util.Collections;

public class Quicksort {

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) if (i == hi) break;
            while(less(a[lo], a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] array) {
        Collections.shuffle(Arrays.asList(array));
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable item = a[i];
        a[i] = a[j];
        a[j] = item;
    }
}
