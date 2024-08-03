import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.*;
import java.util.function.Function;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.lines().collect(Collectors.joining("\n"));

        Pattern pattern = Pattern.compile("\\b\\w+\\b");

        List<String> topWords = pattern.matcher(input.toLowerCase())
                .results()
                .map(MatchResult::group)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        topWords.forEach(System.out::println);
    }
}