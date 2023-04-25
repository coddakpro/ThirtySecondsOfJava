package CollectionsInterface;

public class SelectionSortArray {
    public static void selectionSort(int[] arr){
        var len = arr.length;

        for (var i = 0; i < len -1; i++){
            var minIndex = i;
            int J = 0;
            for (var j = i + 1; j < len; J++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            var tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }
}
