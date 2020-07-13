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
public class User extends Profile{

    int points;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_following")
    List<User> following;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_followers")
    List<User> followers;
    //user is field name in Post table
    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> posts;
    @Enumerated
    Badge badge;

    public enum Badge {
        PLATINUM, GOLD, SILVER, BRONZE
    }
}
