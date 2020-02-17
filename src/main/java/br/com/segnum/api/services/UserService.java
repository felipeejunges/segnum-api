package br.com.segnum.api.services;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User insert(User obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }
}
