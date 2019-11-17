package com.backend.codigobackend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface CurtirPostRepository extends Repository<CurtirPost, Integer> {
    List<CurtirPost> findAll();
    CurtirPost findById(int id);
    CurtirPost save(CurtirPost curtirPost);
    void delete(CurtirPost curtirPost);
    CurtirPost findByEmailCurtiu(String emailCurtiu);
    CurtirPost findByEmailCurtido(String emailCurtido);
    CurtirPost findByIdPost(String idPost);
    void deleteAll();
}
