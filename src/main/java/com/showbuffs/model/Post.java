package com.showbuffs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Setter
@Getter
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
    @JoinColumn(name =  "post_id")
    List<Comment> comments;
}
