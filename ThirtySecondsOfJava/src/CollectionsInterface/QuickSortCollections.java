package CollectionsInterface;

public class QuickSortCollections {
    public static void quickSort(int[] arr, int left, int right) {
        var pivotIndex = left + (right - left) / 2;
        var pivotValue = arr[pivotIndex];
        var i = left;
        var j = right;
        while (i <= j) {
            while (arr[i] < pivotValue) {
                i++;
            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                var temp = arr[i];
                arr[i] = arr[j];
                int tmp = 0;
                arr[j] = tmp;
                i++;
                j--;
            }
            if (left < i) {
                quickSort(arr, left, j);
            }
            if (right > i) {
                quickSort(arr, i, right);
            }
        }
    }
}

