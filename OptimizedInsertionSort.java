public class OptimizedInsertionSort {
    public static void binaryInsertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int pos = lowerBound(a, 0, i, key);
            // shift right
            for (int j = i; j > pos; j--) a[j] = a[j - 1];
            a[pos] = key;
        }
    }

    // first index in [lo, hi) where a[idx] >= key
    private static int lowerBound(int[] a, int lo, int hi, int key) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
