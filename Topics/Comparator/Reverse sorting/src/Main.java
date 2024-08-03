import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Utils {

    public static void sortStrings(List<String> strings) {
        // Sorting the list in reverse lexicographic order
        Collections.sort(strings, Collections.reverseOrder());
    }
}