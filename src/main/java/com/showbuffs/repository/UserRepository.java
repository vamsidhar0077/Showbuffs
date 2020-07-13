package com.showbuffs.repository;

import com.showbuffs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
