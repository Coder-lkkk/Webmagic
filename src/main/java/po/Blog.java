package po;

public class Blog {
    String title ;
    String publishTime ;
    String tag ;
    String specialColumn ;
    String author ;
    String sourceUrl ;
    String readNum ;

    public Blog(String title, String publishTime, String tag, String specialColumn, String author, String sourceUrl, String readNum) {
        this.title = title;
        this.publishTime = publishTime;
        this.tag = tag;
        this.specialColumn = specialColumn;
        this.author = author;
        this.sourceUrl = sourceUrl;
        this.readNum = readNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColumn() {
        return specialColumn;
    }

    public void setColumn(String specialColumn) {
        this.specialColumn = specialColumn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", tag='" + tag + '\'' +
                ", specialColumn='" + specialColumn + '\'' +
                ", author='" + author + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", readNum='" + readNum + '\'' +
                '}';
    }
}
