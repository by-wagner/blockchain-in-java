import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class CollectorProduct {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String val : values) {
            numbers.add(Integer.parseInt(val));
        }

        long val = numbers.stream().map(x -> (long) x * x).reduce(1L, (a, b) -> a * b);

        System.out.println(val);
    }
}