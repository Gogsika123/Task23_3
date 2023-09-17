public class QuickSortComparable {

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void quickSort(E[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }
    private static <E extends Comparable<E>> int partition(E[] arr, int low, int high) {
        E pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }
    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] arr = {8, 12, 7, 3, 9};
        quickSort(arr);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }
}
