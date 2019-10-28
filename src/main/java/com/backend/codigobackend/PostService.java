package com.backend.codigobackend;

import java.util.List;

public interface PostService {
    List<Post> listar();
    Post listarId(int id);
    Post add(Post post);
    void delete(Post post);
    Post findByEmail(String email);
}
