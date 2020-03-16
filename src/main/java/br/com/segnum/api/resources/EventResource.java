package br.com.segnum.api.resources;

import br.com.segnum.api.domain.*;
import br.com.segnum.api.domain.Event;
import br.com.segnum.api.dto.commentary.CommentaryEventDTO;
import br.com.segnum.api.dto.commentary.CommentaryUserDTO;
import br.com.segnum.api.dto.event.EventDTO;
import br.com.segnum.api.dto.event.EventNewDTO;
import br.com.segnum.api.dto.event.EventNewSimplifyDTO;
import br.com.segnum.api.dto.location.LocationDTO;
import br.com.segnum.api.dto.vote.VoteEventDTO;
import br.com.segnum.api.dto.vote.VoteUserDTO;
import br.com.segnum.api.repositories.CommentaryRepository;
import br.com.segnum.api.repositories.VoteRepository;
import br.com.segnum.api.services.EventService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="event")
public class EventResource {

    @Autowired
    EventService service;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    CommentaryRepository commentaryRepository;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody EventNewSimplifyDTO dto) {
        Event obj = service.fromDTO(dto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody EventNewSimplifyDTO dto, @PathVariable int id) {
        Event obj = service.fromDTO(dto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value= "", response = EventDTO.class)
    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        Event obj = service.find(id);
        EventDTO dto = new EventDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Event obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<EventDTO>> findAll() {
        List<Event> list = service.findAll();
        List<EventDTO> listDTO = list.stream()
                .map(obj -> new EventDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value="{id}/votes", method= RequestMethod.GET)
    public ResponseEntity<List<VoteEventDTO>> votes(@PathVariable int id) {
        Event event = service.find(id);

        List<Vote> votes = voteRepository.findByEvent(event);

        List<VoteEventDTO> votesDTO = votes.stream()
                .map(obj -> new VoteEventDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(votesDTO);
    }

    @RequestMapping(value="{id}/commentaries", method= RequestMethod.GET)
    public ResponseEntity<List<CommentaryEventDTO>> commentaries(@PathVariable int id) {
        Event event = service.find(id);

        List<Commentary> votes = commentaryRepository.findByEvent(event);

        List<CommentaryEventDTO> commentariesDTO  = votes.stream()
                .map(obj -> new CommentaryEventDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(commentariesDTO);
    }

}
