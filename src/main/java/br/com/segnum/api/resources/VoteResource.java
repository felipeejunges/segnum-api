package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.dto.vote.VoteNewDTO;
import br.com.segnum.api.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value="vote")
public class VoteResource {

    @Autowired
    VoteService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody VoteNewDTO dto) {
        Vote obj = service.fromDTO(dto);
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody VoteNewDTO dto, @PathVariable int id) {
        Vote obj = service.fromDTO(dto);
        obj.setId(id);
        service.update(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
