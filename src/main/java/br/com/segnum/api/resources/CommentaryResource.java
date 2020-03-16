package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.dto.commentary.CommentaryDTO;
import br.com.segnum.api.dto.commentary.CommentaryNewDTO;
import br.com.segnum.api.dto.vote.VoteNewDTO;
import br.com.segnum.api.services.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="comment")
public class CommentaryResource {

    @Autowired
    CommentaryService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody CommentaryNewDTO dto) {
        Commentary obj = service.fromDTO(dto);
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody CommentaryNewDTO dto, @PathVariable int id) {
        Commentary obj = service.fromDTO(dto);
        obj.setId(id);
        service.update(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
//
//    @RequestMapping(value="{id}", method= RequestMethod.GET)
//    public ResponseEntity<?> find(@PathVariable int id) {
//        Commentary obj = service.find(id);
//        return ResponseEntity.ok().body(obj);
//    }
//
//    @RequestMapping(method= RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable int id) {
//        Commentary obj = service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(method= RequestMethod.GET)
//    public ResponseEntity<List<Commentary>> findAll() {
//        List<Commentary> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }

}
