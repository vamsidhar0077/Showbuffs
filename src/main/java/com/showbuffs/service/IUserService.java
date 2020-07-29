package com.showbuffs.service;

import com.showbuffs.model.Profile;
import com.showbuffs.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
    boolean hasId(String id);
    void createProfile(User user);
    Optional<User> signin(Profile profile);
    User updateProfile(User profile);
    boolean deleteProfile(User profile);
    void followUser(String id, User user);
    void unFollowUser(String id, User user);
}
