package com.showbuffs.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Entity
public class Checklist {

    @EmbeddedId
    ChecklistKey id;
    boolean bucketlist;
    boolean favorite;
    boolean watched;

    public Checklist() {
    }

    public ChecklistKey getId() {
        return id;
    }

    public void setId(ChecklistKey id) {
        this.id = id;
    }

    public boolean isBucketlist() {
        return bucketlist;
    }

    public void setBucketlist(boolean bucketlist) {
        this.bucketlist = bucketlist;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
