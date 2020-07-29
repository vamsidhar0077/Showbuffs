package com.showbuffs.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int upvotes;
    String description;
    String oneword;
    double rating;
    @ManyToOne(fetch = FetchType.LAZY)
    User user;
    @ManyToOne
    Tvshow show;
    @OneToMany
    @JoinColumn(name = "post_id")
    List<Comment> comments = new ArrayList<>();

    public Post() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOneword() {
        return oneword;
    }

    public void setOneword(String oneword) {
        this.oneword = oneword;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tvshow getShow() {
        return show;
    }

    public void setShow(Tvshow show) {
        this.show = show;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
