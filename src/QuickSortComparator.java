import java.util.Comparator;

public class QuickSortComparator {
    public static <E> void quickSort(E[] arr, Comparator<? super E> comparator) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1, comparator);
    }
    private static <E> void quickSort(E[] arr, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, comparator);
            quickSort(arr, low, pivotIndex - 1, comparator);
            quickSort(arr, pivotIndex + 1, high, comparator);
        }
    }
    private static <E> int partition(E[] arr, int low, int high, Comparator<? super E> comparator) {
        E pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 3, 6};
        Comparator<Integer> comparator = Integer::compareTo;
        quickSort(arr, comparator);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }
}
