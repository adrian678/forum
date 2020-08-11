package ca.forum.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long cid;                //TODO add @Notnull annotations
    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Post parentPost;
    @ManyToOne(cascade = CascadeType.ALL) //TODO right cascade type?
    @JoinColumn
    private Comment parentComment;
    @JoinColumn
    User author;
    @NonNull
    String content;
    @NonNull
    private Date timestamp;
    @NonNull
    private int points;

    public Comment(Post parentPost, Comment parentComment, User author, String content){
        this.points = 1;
        this.timestamp = new Date(System.currentTimeMillis());
        this.parentPost = parentPost;
        this.parentComment = parentComment;
        this.author = author;
        this.content = content;
    }

    public Post getParentPost(){
        return parentPost;
    }

    public Comment getParentComment(){
        return parentComment;
    }

    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
