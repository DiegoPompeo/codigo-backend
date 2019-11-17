package com.backend.codigobackend;

import java.util.List;

public interface CurtirPostService {
    List<CurtirPost> findAll();
    CurtirPost findById(int id);
    CurtirPost save(CurtirPost curtirPost);
    CurtirPost edit(CurtirPost curtirPost);
    void delete(CurtirPost curtirPost);
    CurtirPost findByEmailCurtiu(String emailCurtiu);
    CurtirPost findByEmailCurtido(String emailCurtido);
    CurtirPost findByIdPost(String idPost);
    void deleteAll();
}
