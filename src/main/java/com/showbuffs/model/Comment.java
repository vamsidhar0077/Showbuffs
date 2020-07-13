package com.showbuffs.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Setter
@Getter
@Entity
public class Comment {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String comment;
}
