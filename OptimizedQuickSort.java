public class OptimizedQuickSort {
    private static final int CUTOFF = 12;

    public static void quickSort(int[] a) {
        if (a == null || a.length <= 1) return;
        quickSort(a, 0, a.length - 1);
        insertionSortRange(a, 0, a.length - 1); // finish small partitions
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (hi - lo <= CUTOFF) return;

        int pivot = medianOfThree(a, lo, hi);
        int i = lo, j = hi - 1;
        while (true) {
            while (a[++i] < pivot) {}
            while (a[--j] > pivot) {}
            if (i < j) swap(a, i, j);
            else break;
        }
        swap(a, i, hi - 1); // restore pivot
        quickSort(a, lo, i - 1);
        quickSort(a, i + 1, hi);
    }

    private static int medianOfThree(int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < a[lo]) swap(a, lo, mid);
        if (a[hi] < a[lo]) swap(a, lo, hi);
        if (a[hi] < a[mid]) swap(a, mid, hi);
        // place pivot at hi-1
        swap(a, mid, hi - 1);
        return a[hi - 1];
    }

    private static void insertionSortRange(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= lo && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
