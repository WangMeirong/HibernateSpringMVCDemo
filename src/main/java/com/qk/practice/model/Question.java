package com.qk.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    // @Size(min=3, max=50)
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_timestamp", nullable = false)
    private long createdTimestamp;

    @Column(name = "last_modified_timestamp", nullable = false)
    private long lastModifiedTimestamp;

    public Question() {
        super();
    }

    public Question(String id, String title, String content, long createdTimestamp,
            long lastModifiedTimestamp) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdTimestamp = createdTimestamp;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public long getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    @Override
    public int hashCode() {
        return id.hashCode() + title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Question) {
            Question other = (Question) obj;
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "id:" + id + ", title:" + title;
    }

}
