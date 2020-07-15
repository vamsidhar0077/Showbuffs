package com.showbuffs.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created By ReddyGadu
 * Created On 7/11/20
 * Project Name ShowBuffs
 **/
@MappedSuperclass
public class Profile {
    @Column
    @Id
    String id;
    String username;
    String password;
    byte[] displayPicture;
    String token;
    Profile(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(byte[] displayPicture) {
        this.displayPicture = displayPicture;
    }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }
}
