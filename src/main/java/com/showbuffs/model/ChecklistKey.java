package com.showbuffs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created By ReddyGadu
 * Created On 7/13/20
 * Project Name ShowBuffs
 **/

@Embeddable
public class ChecklistKey implements Serializable {
    @Column
    String email;
    @Column
    long tvshow;
}