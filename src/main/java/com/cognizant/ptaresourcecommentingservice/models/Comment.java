package com.cognizant.ptaresourcecommentingservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private Integer resourceId;
    private String comment;

    public Comment() {
    }

    public Comment(Integer id, Integer resourceId, String comment) {
        Id = id;
        this.resourceId = resourceId;
        this.comment = comment;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(Id, comment1.Id) && Objects.equals(resourceId, comment1.resourceId) && Objects.equals(comment, comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, resourceId, comment);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id=" + Id +
                ", resourceId=" + resourceId +
                ", comment='" + comment + '\'' +
                '}';
    }
}

