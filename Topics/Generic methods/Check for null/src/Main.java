// do not remove imports
import java.util.*;
import java.util.function.Function;

class ArrayUtils {
    public static <T> boolean hasNull(T[] t) {
        return Arrays.stream(t).anyMatch(Objects::isNull);
    }
}
