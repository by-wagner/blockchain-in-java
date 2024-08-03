import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<String> extractCodes(List<String> codes) {
        // Drop elements until we find "#0000"
        List<String> result = codes.stream()
                .dropWhile(code -> !code.equals("#0000"))
                .skip(1) // Skip "#0000"
                // Take elements until we find "#FFFF"
                .takeWhile(code -> !code.equals("#FFFF"))
                .collect(Collectors.toList());

        return result;
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}