package com.showbuffs.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@Setter
@Getter
@MappedSuperclass
class Profile {
    @Column
    @Id
    String id;
    String username;
    String password;
    byte[] displayPicture;
    
    Profile(){}

}
