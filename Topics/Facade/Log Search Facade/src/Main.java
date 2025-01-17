import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Do not change the method
class FacadeMain {
    public static void main(String[] args) {
        LogSearchFacade logSearcher = new LogSearchFacade(
                new LogCollector(), new LogFilter(), new LogFormatter());
        List<String> foundLogs = logSearcher.search("ERROR");

        for (String log : foundLogs) {
            System.out.println(log);
        }
    }
}

class LogSearchFacade {
    private final LogCollector collector;
    private final LogFilter filter;
    private final LogFormatter formatter;

    public LogSearchFacade(LogCollector collector, LogFilter filter, LogFormatter formatter) {
        this.collector = collector;
        this.filter = filter;
        this.formatter = formatter;
    }

    public List<String> search(String expr) {
        // Collect logs
        List<String> collectedLogs = collector.collect();
        // Filter logs
        List<String> filteredLogs = filter.filter(collectedLogs, expr);
        // Format logs
        List<String> formattedLogs = formatter.format(filteredLogs);
        // Return formatted logs
        return formattedLogs;
    }
}

// Do not change code below
class LogCollector {
    /**
     * The method reads lines from a standard input
     * @return a list of logs
     */
    public List<String> collect() {
        List<String> logs = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input
        for (int i = 0; i < num; ++i) {
            String log = scanner.nextLine();
            logs.add(log);
        }

        return logs;
    }
}

class LogFilter {
    /**
     * The method filters input logs, that matches an expression value
     * @param lines is a list of input logs
     * @param expr is an expression value
     * @return logs, that contain an expression value
     */
    public List<String> filter(List<String> lines, String expr) {
        List<String> matches = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(expr)) {
                matches.add(line);
            }
        }

        return matches;
    }
}

class LogFormatter {
    /**
     * The method applies a transformation logic to each element of an input list.
     * If an element has ': '
     *   substring the transformation logic splits the element into 2 parts by this delimiter and takes the second part
     * Otherwise the method takes an element as is
     * @param logs is a list of input elements
     * @return a transformed list
     */
    public List<String> format(List<String> logs) {
        List<String> formattedLogs = new ArrayList<>();
        for (String log : logs) {
            String[] levelAndMessage = log.split(": ");
            String formattedLog = levelAndMessage.length > 1 ? levelAndMessage[1] : log;
            formattedLogs.add(formattedLog);
        }

        return formattedLogs;
    }
}