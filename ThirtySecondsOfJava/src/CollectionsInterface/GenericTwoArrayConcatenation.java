package CollectionsInterface;

import java.util.Arrays;

public class GenericTwoArrayConcatenation {

    public static <T> T[] arrayConcat(T[] first, T[] second) {
        var result = Arrays.copyOf(first, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    }

