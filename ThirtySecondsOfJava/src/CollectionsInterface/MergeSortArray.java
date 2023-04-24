package CollectionsInterface;

public class MergeSortArray {
    public  static void mergesort(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        int mid = (low+high)/ 2;
        mergesort(arr, low, mid);
        mergesort(arr, mid+1, high);
        merge(arr, low, high, mid);
    }

    private static void merge(int[] arr, int low, int high, int mid) {
        int[] temp = new int[(high-low+1)];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high){
            if (arr[i]<arr[j]){
                temp[k++] = arr[i];
                i++;
            }
            else {
                temp[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid){
            temp[k++] = arr[i];
            i++;
        }
        while (j <= high){
            temp[k++] = arr[j];
            j++;
        }

        for (int m = 0, n = low; m < temp.length; m++, n++){
            arr[n] = temp[m];
        }
    }
}
