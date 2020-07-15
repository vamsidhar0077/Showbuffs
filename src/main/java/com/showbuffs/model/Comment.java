package com.showbuffs.model;

import javax.persistence.*;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Entity
public class Comment {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String comment;

    public Comment() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
