package com.showbuffs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Setter
@Getter
@Entity
public class Tvshow {
    @Column
    @Id
    long id;
    int seasons;
    int upvotes;
    byte[] logo;
    int downvotes;
    double rating;
    Date releaseDate;
    String description;
    String showname;
    String crew;
    String screeningAt;
    @OneToMany(mappedBy = "show")
    List<Post> reviews;

    public Tvshow(){}
}
