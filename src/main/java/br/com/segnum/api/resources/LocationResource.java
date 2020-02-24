package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Location;
import br.com.segnum.api.dto.location.LocationNewDTO;
import br.com.segnum.api.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="location")
public class LocationResource {

    @Autowired
    LocationService service;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Location obj) {
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="user/{userId}", method= RequestMethod.POST)
    public ResponseEntity<Void> insertUserLocation(@RequestBody LocationNewDTO dto, @PathVariable int userId) {
        Location obj = service.insertUserLocation(dto, userId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="event/{eventId}", method= RequestMethod.POST)
    public ResponseEntity<Void> inserEventLocation(@RequestBody LocationNewDTO dto, @PathVariable int eventId) {
        Location obj = service.insertEventLocation(dto, eventId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Location obj, @PathVariable int id) {
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        Location obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Location obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Location>> findAll(@PathVariable int id) {
        List<Location> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
