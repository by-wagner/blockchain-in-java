import java.util.*;
import java.time.Instant;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Instant> instantList = createInstantList(scanner);

        long result = getMaxMinusMin(instantList);

        System.out.println(result);
    }

    public static List<Instant> createInstantList(Scanner scanner) {
        List<Instant> instantList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;
            instantList.add(Instant.parse(line));
        }

        return instantList;
    }

    private static long getMaxMinusMin(List<Instant> instantList) {
        if (instantList.isEmpty()) {
            return 0;
        }

        Instant minInstant = Collections.min(instantList);
        Instant maxInstant = Collections.max(instantList);

        Duration duration = Duration.between(minInstant, maxInstant);

        return duration.getSeconds();
    }
}