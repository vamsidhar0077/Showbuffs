package com.showbuffs.repository;

import com.showbuffs.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByIdAndPassword(String id, String password);
}
