// You can experiment here, it won’t be checked

import java.util.stream.IntStream;

public class Task {
  public static void main(String[] args) {
    boolean result = IntStream
            .iterate(0, n -> n + 1)
            .limit(100)
            .filter(n -> n % 2 != 0)
            .noneMatch(n -> n % 2 == 0);

    System.out.println(result);
  }
}
