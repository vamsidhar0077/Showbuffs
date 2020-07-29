package com.showbuffs.service;

import com.showbuffs.model.Profile;
import com.showbuffs.model.User;
import com.showbuffs.repository.UserRepository;
import com.showbuffs.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created By ReddyGadu
 * Created On 7/14/20
 * Project Name ShowBuffs
 **/
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    public boolean hasId(String id) {
        return userRepository.existsById(id);
    }

    public void createProfile(User user) {
        modifyUserPoints(user, 10);
        user.setBadge(User.Badge.BRONZE);
        userRepository.save(user);
    }

    public Optional<User> signin(Profile profile) {
        Optional<User> user = userRepository.findByIdAndPassword(profile.getId(), profile.getPassword());
        if (user.isPresent()) {
            User current = user.get();
            org.springframework.security.core.userdetails.User ud =
                    new org.springframework.security.core.userdetails.User
                            (current.getId(), current.getPassword(), new ArrayList<>());
            String token = jwtUtil.generateToken(ud);
            current.setToken(token);
        }
        return user;
    }

    public void modifyUserPoints(User user, int points) {
        user.setPoints(user.getPoints() + points);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username);
        User current = user.get();
        return new org.springframework.security.core.userdetails.User(current.getId(), current.getPassword(), new ArrayList<>());
    }


    @Override
    public User updateProfile(User profile) {
        if(hasId(profile.getId())) {
            User user = cloneUser(profile);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteProfile(User profile) {
        if(hasId(profile.getId())) {
            try {
                userRepository.deleteById(profile.getId());
                return true;
            }
            catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public void followUser(String id, User user) {
        if(hasId(id)) {
            User current = userRepository.findById(id).get();
            user = cloneUser(user);
            user.getFollowing().add(current);
            current.getFollowers().add(user);
            userRepository.save(user);
            userRepository.save(current);
        }
    }

    @Override
    public void unFollowUser(String id, User user) {
        if(hasId(id)) {
            User current = userRepository.findById(id).get();
            user = cloneUser(user);
            user.getFollowing().remove(current);
            current.getFollowers().remove(current);
            userRepository.save(user);
            userRepository.save(current);
        }
    }


    public User cloneUser(User input) {
        if(hasId(input.getId())) {
            User persisted = userRepository.findById(input.getId()).get();
            if(input.getPoints() == 0)
                input.setPoints(persisted.getPoints());
            if(input.getBadge() == null)
                input.setBadge(persisted.getBadge());
            if(input.getFollowers().isEmpty())
                input.setFollowers(persisted.getFollowers());
            if(input.getFollowing().isEmpty())
                input.setFollowing(persisted.getFollowing());
            if(input.getDisplayPicture() == null)
                input.setDisplayPicture(persisted.getDisplayPicture());
            if(input.getPassword() == null || input.getPassword().isEmpty())
                input.setPassword(persisted.getPassword());
            if(input.getUsername() == null || input.getUsername().isEmpty())
                input.setUsername(persisted.getUsername());
            if(input.getPosts().isEmpty())
                input.setPosts(persisted.getPosts());
        }
        return input;
    }

}
