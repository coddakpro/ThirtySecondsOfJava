package CollectionsInterface;

import java.util.Arrays;

public class GenericNArrayConcatenation {
    @SafeVarargs
    public static <T> T[] nArrayConcat(T[] first, T[]... rest){
        var totalLength = first.length;
        for (var array : rest){
            totalLength += array.length;
        }
        var result = Arrays.copyOf(first, totalLength);
        var offset = first.length;
        for (var array : rest){
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
