package br.com.segnum.api.resources;

import br.com.segnum.api.domain.User;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.UserNewDTO;
import br.com.segnum.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="user")
public class UserResource {

    @Autowired
    UserService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody UserNewDTO dto) {
        User obj = service.fromDTO(dto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserNewDTO dto, @PathVariable int id) {
        User obj = service.fromDTO(dto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        User obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        User obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(@PathVariable int id) {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
