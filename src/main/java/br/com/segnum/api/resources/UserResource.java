package br.com.segnum.api.resources;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="user")
public class UserResource {

    @Autowired
    UserService service;

    @RequestMapping(method= RequestMethod.POST)
    public String register(@RequestBody User obj) {
        service.insert(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public String update(@RequestBody User obj, @PathVariable int id) {
        service.update(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public User find(@PathVariable int id) {
        User obj = service.find(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public User delete(@PathVariable int id) {
        User obj = service.delete(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<User> findAll(@PathVariable int id) {
        List<User> list = service.findAll();
        return list;
    }

}
