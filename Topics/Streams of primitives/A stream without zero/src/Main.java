import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class StreamOfPrimitives {

    public static LongStream getLongStream(int n) {
        return LongStream.rangeClosed(-n, n)
                .filter(value -> value != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String result = getLongStream(n)
                .mapToObj(Long::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}