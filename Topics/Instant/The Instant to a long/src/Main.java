import java.util.Scanner;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(dateInEpochSeconds(scanner.nextLine()));
    }

    public static long dateInEpochSeconds(String text) {
        try {
            Instant instant = Instant.parse(text);
            return instant.getEpochSecond();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
            return -1;
        }
    }
}