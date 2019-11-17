package com.backend.codigobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtirPostServiceImp implements CurtirPostService{
    @Autowired
    private CurtirPostRepository curtirPostRepository;

    @Override
    public List<CurtirPost> findAll() {
        return curtirPostRepository.findAll();
    }

    @Override
    public CurtirPost findById(int id) {
        return curtirPostRepository.findById(id);
    }

    @Override
    public CurtirPost save(CurtirPost curtirPost) {
        return curtirPostRepository.save(curtirPost);
    }

    @Override
    public CurtirPost edit(CurtirPost curtirPost) {
        return curtirPostRepository.save(curtirPost);
    }

    @Override
    public void delete(CurtirPost curtirPost) {
        curtirPostRepository.delete(curtirPost);
    }

    @Override
    public CurtirPost findByEmailCurtiu(String emailCurtiu) {
        return curtirPostRepository.findByEmailCurtiu(emailCurtiu);
    }

    @Override
    public CurtirPost findByEmailCurtido(String emailCurtido) {
        return curtirPostRepository.findByEmailCurtido(emailCurtido);
    }

    @Override
    public CurtirPost findByIdPost(String idPost) {
        return curtirPostRepository.findByIdPost(idPost);
    }

    @Override
    public void deleteAll() {
        curtirPostRepository.deleteAll();
    }
}
