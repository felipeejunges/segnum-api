package br.com.segnum.api.services;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.repositories.UserRepository;
import br.com.segnum.api.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository repo;

    public Vote insert(Vote obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }
}
