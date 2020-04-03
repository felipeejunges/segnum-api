package br.com.segnum.api.resources;

import br.com.segnum.api.domain.EventType;
import br.com.segnum.api.dto.eventType.EventTypeSimplifyDTO;
import br.com.segnum.api.services.EventTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="EventType")
public class EventTypeResource {

    @Autowired
    EventTypeService service;

    @ApiOperation(value= "", response = EventTypeSimplifyDTO.class)
    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        EventType obj = service.find(id);
        EventTypeSimplifyDTO dto = new EventTypeSimplifyDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<EventTypeSimplifyDTO>> findAll() {
        List<EventType> list = service.findAll();
        List<EventTypeSimplifyDTO> listDTO = list.stream()
                .map(obj -> new EventTypeSimplifyDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
