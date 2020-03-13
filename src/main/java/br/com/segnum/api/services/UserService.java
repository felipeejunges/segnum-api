package br.com.segnum.api.services;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.user.UserNewDTO;
import br.com.segnum.api.repositories.UserRepository;
import br.com.segnum.api.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User insert(User obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }

    public User update(User obj) {
        obj = repo.save(obj);
        return obj;
    }

    public User find(int id) {
        Optional<User> obj = repo.findById(id);
        return obj.get();
    }

    public List<User> findAll() {
        List<User> list = repo.findAll();
        return list;
    }

    public User delete(int id) {
        User obj = find(id);
        repo.delete(obj);
        return obj;
    }

    public User fromDTO(UserNewDTO objDto) {
        return new User(0, objDto.getName(), objDto.getEmail(), objDto.getPhone(), objDto.getBirthday(), objDto.getPassword());
    }

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }
}
