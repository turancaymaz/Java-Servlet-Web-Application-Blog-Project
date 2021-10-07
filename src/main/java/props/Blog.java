package props;

import java.util.Date;

public class Blog {

    private int bid;
    private String author;
    private String title;
    private String content;
    private String detail;
    private Date date;

    public Blog(){

    }

    public Blog(int bid, String author, String title, String content, String detail, Date date) {
        this.bid = bid;
        this.author = author;
        this.title = title;
        this.content = content;
        this.detail = detail;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() { return detail; }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
