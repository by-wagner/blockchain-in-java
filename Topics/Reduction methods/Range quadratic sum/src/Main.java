import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return IntStream.range(fromIncl, toExcl)
                .map(i -> i * i)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(rangeQuadraticSum(10, 12));
        System.out.println(rangeQuadraticSum(5, 6));
        System.out.println(rangeQuadraticSum(3, 3));
    }
}