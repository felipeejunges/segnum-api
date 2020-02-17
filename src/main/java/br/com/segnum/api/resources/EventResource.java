package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.Event;
import br.com.segnum.api.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="event")
public class EventResource {

    @Autowired
    EventService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody Event obj) {
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Event obj, @PathVariable int id) {
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        Event obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Event obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Event>> findAll(@PathVariable int id) {
        List<Event> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
