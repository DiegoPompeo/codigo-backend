package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImp implements PostService {
    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> listar() {
        return repository.findAll();
    }

    @Override
    public Post listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Post add(Post post) {
        return repository.save(post);
    }

    @Override
    public void delete(Post post) {
        repository.delete(post);
    }

    @Override
    public Post findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
