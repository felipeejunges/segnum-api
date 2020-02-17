package br.com.segnum.api.services;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.repositories.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaryService {

    @Autowired
    private CommentaryRepository repo;

    public Commentary insert(Commentary obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }

    public Commentary update(Commentary obj) {
        obj = repo.save(obj);
        return obj;
    }

    public Commentary find(int id) {
        Optional<Commentary> obj = repo.findById(id);
        return obj.get();
    }

    public List<Commentary> findAll() {
        List<Commentary> list = repo.findAll();
        return list;
    }

    public Commentary delete(int id) {
        Commentary obj = find(id);
        repo.delete(obj);
        return obj;
    }
}
