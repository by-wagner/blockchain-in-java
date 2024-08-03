import java.util.*;
import java.util.stream.Collectors;

class Monitor {

    public static Map<String, Long> getUrlToNumberOfVisited(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
    }

    static class LogEntry {

        private Date created;
        private String login;
        private String url;

        public LogEntry(Date created, String login, String url) {
            this.created = created;
            this.login = login;
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LogEntry)) {
                return false;
            }

            LogEntry logEntry = (LogEntry) o;

            if (!login.equals(logEntry.login)) {
                return false;
            }
            return url.equals(logEntry.url);
        }

        @Override
        public int hashCode() {
            int result = login.hashCode();
            result = 31 * result + url.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "created=" + created +
                    ", login='" + login + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry(new Date(), "user1", "http://example.com/page1"),
                new LogEntry(new Date(), "user2", "http://example.com/page1"),
                new LogEntry(new Date(), "user3", "http://example.com/page2"),
                new LogEntry(new Date(), "user1", "http://example.com/page3"),
                new LogEntry(new Date(), "user2", "http://example.com/page2"),
                new LogEntry(new Date(), "user3", "http://example.com/page1")
        );

        Map<String, Long> urlToNumberOfVisited = getUrlToNumberOfVisited(logs);
        urlToNumberOfVisited.forEach((url, count) -> System.out.println(url + " -> " + count));
    }
}