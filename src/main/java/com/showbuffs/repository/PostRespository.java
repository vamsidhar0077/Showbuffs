package com.showbuffs.repository;

import com.showbuffs.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRespository extends CrudRepository<Post, Long> {
}
