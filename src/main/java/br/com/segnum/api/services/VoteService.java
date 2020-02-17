package br.com.segnum.api.services;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.repositories.UserRepository;
import br.com.segnum.api.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository repo;

    public Vote insert(Vote obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }

    public Vote update(Vote obj) {
        obj = repo.save(obj);
        return obj;
    }

    public Vote find(int id) {
        Optional<Vote> obj = repo.findById(id);
        return obj.get();
    }

    public List<Vote> findAll() {
        List<Vote> list = repo.findAll();
        return list;
    }

    public Vote delete(int id) {
        Vote obj = find(id);
        repo.delete(obj);
        return obj;
    }
}
