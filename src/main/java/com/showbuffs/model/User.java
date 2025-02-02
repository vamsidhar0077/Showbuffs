package com.showbuffs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Entity
public class User extends Profile{

    int points;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_following")
    @JsonIgnore
    List<User> following = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_followers")
    @JsonIgnore
    List<User> followers = new ArrayList<>();
    //user is field name in Post table
    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();
    @Enumerated
    Badge badge;


    public enum Badge {
        PLATINUM, GOLD, SILVER, BRONZE
    }

    public User() {}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public String toString() {
        return this.username;
    }
}
