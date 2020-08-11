package ca.forum.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long pid;            //TODO add @Notnull annotations
    @ManyToOne
    @JoinColumn
    @NonNull
    private User author;
    @NonNull
    private String content;
    @NonNull
    private String title;
    @NonNull
    private int points;
    @NonNull
    private Date timestamp;
    @ManyToOne
    @JoinColumn
    @NonNull
    private Topic topic;




    public Post(){
        this.points = 1;
    }

    public Post(User author, String title, String content, Topic topic){
        this.points = 1;
        this.author = author;
        this.title=title;
        this.content = content;
        this.topic = topic;
        this.timestamp = new Date(System.currentTimeMillis());
    }

    public long getPid() {
        return pid;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int getPoints() {
        return points;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
