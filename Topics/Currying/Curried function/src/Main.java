import java.util.Scanner;
import java.util.function.IntFunction;

class CurryProduct {
    public static int calc(int x, int y, int z) {
        IntFunction<IntFunction<IntFunction<Integer>>> f = 
            a -> b -> c -> a + b * b + c * c * c;
        return f.apply(x).apply(y).apply(z);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");

        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        int z = Integer.parseInt(values[2]);

        System.out.println(calc(x, y, z));
    }
}