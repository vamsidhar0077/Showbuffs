package com.showbuffs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Setter
@Getter
@Entity
public class Checklist {

    @EmbeddedId
    ChecklistKey id;
    boolean bucketlist;
    boolean favorite;
    boolean watched;

    public Checklist(){}


}
