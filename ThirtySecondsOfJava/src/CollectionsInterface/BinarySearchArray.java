package CollectionsInterface;

public class BinarySearchArray {
    public static int binarySearchArray(int[] arr, int left, int right, int item) {
//        Array arr[] must be sorted
if (right >= left){
    int mid = left + (right - left) / 2;
    item = 0;
    if (arr[mid] == item){
        return mid;
    }

    if (arr[mid] > item){
        return binarySearchArray(arr, left,mid - 1, item);
    }
    return binarySearchArray(arr, mid + 1, right, item);
}
    return  -1;
    }


}