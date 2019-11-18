package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface PostRepository extends Repository<Post, Integer> {
    List<Post> findAll();
    Post findById(String codPost);
    void delete(Post post);
    Post save(Post post);
    Post findByEmail(String email);
}
