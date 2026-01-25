public class threeWayPartitioningDijkstraQS {

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable firstItem = a[lo];
        int i = lo;
        while(i <= gt) {
            int compare = a[i].compareTo(firstItem);
            if (compare < 0) exchange(a, lt++, i++);
            else if (compare > 0) exchange(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable item = a[i];
        a[i] = a[j];
        a[j] = item;
    }
}
