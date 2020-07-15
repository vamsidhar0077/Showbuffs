package com.showbuffs.controller;

import com.showbuffs.model.Profile;
import com.showbuffs.model.User;
import com.showbuffs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created By ReddyGadu
 * Created On 7/13/20
 * Project Name ShowBuffs
 **/
@RestController
@RequestMapping(value = "showbuffs/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@RequestBody User profile) {
        boolean idExists = userService.hasId(profile.getId());
        if (idExists) {
            return "Email already exists.!";
        } else {
            userService.createProfile(profile);
            return "Welcome " + profile.getUsername() + " to Showbuffs.!";
        }
    }

    @RequestMapping(value = "/checkIfIdExists", method = RequestMethod.GET)
    public boolean checkIdExists(@RequestParam(name = "email") String id) {
        return userService.hasId(id);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ResponseEntity signin(@RequestBody Profile profile) {
        Optional<User> user = userService.signin(profile);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Email or Password specified may not be correct");
        }
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public ResponseEntity updateProfile(@RequestBody User profile) {
        User user = userService.updateProfile(profile);
        if (user == null) {
            return ResponseEntity.badRequest().body("User Profile cannot be updated");
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @RequestMapping(value = "/deleteProfile", method = RequestMethod.POST)
    public ResponseEntity deleteProfile(@RequestBody User profile) {
        boolean deleted = userService.deleteProfile(profile);
        return deleted ? ResponseEntity.status(200).build() :
                ResponseEntity.status(400).body("Unable to perform delete");
    }
}
