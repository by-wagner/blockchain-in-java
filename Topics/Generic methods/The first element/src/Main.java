import java.util.*;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T getFirst(T[] t) {
        return Arrays.stream(t).findFirst().orElse(null);
    }
}