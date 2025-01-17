import java.util.Scanner;
import java.util.function.*;

class CustomReducer {

    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (seed, combiner) -> (left, right) -> {
                int result = seed;
                for (int i = left; i <= right; i++) {
                    result = combiner.applyAsInt(result, i);
                }
                return result;
            };

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x, y) -> x + y);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x, y) -> x * y);

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");

        int l = Integer.parseInt(values[0]);
        int r = Integer.parseInt(values[1]);

        CustomReducer reducer = new CustomReducer();

        int sumReducer = reducer.reduceIntOperator.apply(0, Integer::sum).applyAsInt(l, r);
        int sum = reducer.sumOperator.applyAsInt(l, r);

        int prodReducer = reducer.reduceIntOperator.apply(1, (x, y) -> x * y).applyAsInt(l, r);
        int prod = reducer.productOperator.applyAsInt(l, r);

        System.out.printf("%d %d %d %d", sumReducer, sum, prodReducer, prod);
    }
}