package br.com.segnum.api.services;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.repositories.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaryService {

    @Autowired
    private CommentaryRepository repo;

    public Commentary insert(Commentary obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }
}
