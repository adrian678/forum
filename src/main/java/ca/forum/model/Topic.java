package ca.forum.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long tid;
    @NonNull
    private String title;
    @NonNull
    private long numSubscribers;
    @NonNull
    String description;

    public Topic(){

    }
    public Topic(String title, String description){
        this.title = title;
        this.description = description;
        this.numSubscribers = 1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNumSubscribers() {
        return numSubscribers;
    }

    public void setNumSubscribers(long numSubscribers) {
        this.numSubscribers = numSubscribers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
