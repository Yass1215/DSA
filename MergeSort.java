public class MergeSort {
    public static void mergeSort(int[] a) {
        if (a == null || a.length <= 1) return;
        int[] tmp = new int[a.length];
        mergeSort(a, 0, a.length - 1, tmp);
    }

    private static void mergeSort(int[] a, int l, int r, int[] tmp) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(a, l, m, tmp);
        mergeSort(a, m + 1, r, tmp);
        merge(a, l, m, r, tmp);
    }

    private static void merge(int[] a, int l, int m, int r, int[] tmp) {
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) tmp[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        System.arraycopy(tmp, 0, a, l, k);
    }
}
