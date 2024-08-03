class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {

        int sizeComparison = Integer.compare(this.size, otherArticle.size);

        if (sizeComparison == 0) {
            return this.title.compareTo(otherArticle.title);
        }
        return sizeComparison;
    }
}