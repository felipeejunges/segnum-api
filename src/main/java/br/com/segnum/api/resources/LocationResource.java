package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Location;
import br.com.segnum.api.dto.location.LocationDTO;
import br.com.segnum.api.dto.location.LocationNewDTO;
import br.com.segnum.api.services.LocationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

//    @RequestMapping(value="{id}", method= RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody Location LocationNewDTO, @PathVariable int id) {
//        Location obj =
//        service.update(obj);
//        return ResponseEntity.noContent().build();
//    }

    @ApiOperation(value= "", response = List.class)
    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        Location obj = service.find(id);
        LocationDTO dto = new LocationDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @PreAuthorize("hasAnyRole('MASTER', 'ADMINISTRATOR', 'MODERATOR')")
    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Location obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<LocationDTO>> findAll() {
        List<Location> list = service.findAll();
        List<LocationDTO> listDTO = list.stream()
                .map(obj -> new LocationDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
