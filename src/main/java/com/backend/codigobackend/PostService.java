package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PostService {
    @Autowired
    private PostRepository repository;

    List<Post> listar() {
        return repository.findAll();
    }

    Post edit(Post post){
        return repository.save(post);
    }

    Post listarId(int id) {
        return repository.findById(id);
    }

    Post add(Post post) {
        return repository.save(post);
    }

    void delete(Post post) {
        repository.delete(post);
    }

    Post findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
