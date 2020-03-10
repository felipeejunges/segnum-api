package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="vote")
public class VoteResource {

    @Autowired
    VoteService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody Vote obj) {
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

//    @RequestMapping(value="{id}", method= RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody Vote obj, @PathVariable int id) {
//        service.update(obj);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(value="{id}", method= RequestMethod.GET)
//    public ResponseEntity<?> find(@PathVariable int id) {
//        Vote obj = service.find(id);
//        return ResponseEntity.ok().body(obj);
//    }
//
//    @RequestMapping(method= RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable int id) {
//        Vote obj = service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(method= RequestMethod.GET)
//    public ResponseEntity<List<Vote>> findAll() {
//        List<Vote> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }

}
