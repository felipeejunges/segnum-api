package br.com.segnum.api.resources;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="user")
public class UserResource {

    @Autowired
    UserService service;

    @RequestMapping(method= RequestMethod.GET)
    public String test() {
        return "user";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String register(User user) {
        service.insert(user);
        return "sucesso";
    }

}
