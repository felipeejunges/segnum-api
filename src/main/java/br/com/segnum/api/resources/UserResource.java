package br.com.segnum.api.resources;

import br.com.segnum.api.domain.*;
import br.com.segnum.api.domain.enums.Profile;
import br.com.segnum.api.dto.commentary.CommentaryUserDTO;
import br.com.segnum.api.dto.event.EventDTO;
import br.com.segnum.api.dto.event.EventSimplifyDTO;
import br.com.segnum.api.dto.location.LocationDTO;
import br.com.segnum.api.dto.location.LocationSimplifyDTO;
import br.com.segnum.api.dto.user.CredentialsDTO;
import br.com.segnum.api.dto.user.UserDTO;
import br.com.segnum.api.dto.user.UserNewDTO;
import br.com.segnum.api.dto.user.ChangeProfileDTO;
import br.com.segnum.api.dto.vote.VoteUserDTO;
import br.com.segnum.api.repositories.CommentaryRepository;
import br.com.segnum.api.repositories.EventRepository;
import br.com.segnum.api.repositories.LocationRepository;
import br.com.segnum.api.repositories.VoteRepository;
import br.com.segnum.api.security.UserSS;
import br.com.segnum.api.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="user")
public class UserResource {

    @Autowired
    UserService service;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    CommentaryRepository commentaryRepository;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody UserNewDTO dto) {
        User obj = service.fromDTOEncode(dto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserNewDTO dto, @PathVariable int id) {
        User obj = service.fromDTOEncode(dto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value= "", response = UserDTO.class)
    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable int id) {
        User obj = service.find(id);
        UserDTO dto = new UserDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @PreAuthorize("hasAnyRole('MASTER', 'ADMINISTRATOR', 'MODERATOR')")
    @RequestMapping(method= RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        User obj = service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream()
                .map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value="{id}/profile/grant", method= RequestMethod.PUT)
    public ResponseEntity<Void> grantProfile(@RequestBody ChangeProfileDTO dto, @PathVariable int id) {
        User obj = service.find(id);
        obj.getProfiles().add(Profile.toEnum(dto.getProfileId()));
        service.update(obj);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="{id}/profile/remove", method= RequestMethod.PUT)
    public ResponseEntity<Void> removeProfile(@RequestBody ChangeProfileDTO dto, @PathVariable int id) {
        User obj = service.find(id);
        obj.getProfiles().remove(Profile.toEnum(dto.getProfileId()));
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="{id}/locations", method= RequestMethod.GET)
    public ResponseEntity<List<LocationSimplifyDTO>> myLocations(@PathVariable int id) {
        User user = service.find(id);

        List<Location> locations = locationRepository.findByUser(user);

        List<LocationSimplifyDTO> locationsDTO = locations.stream()
                .map(obj -> new LocationSimplifyDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(locationsDTO);
    }

    @RequestMapping(value="{id}/events", method= RequestMethod.GET)
    public ResponseEntity<List<EventSimplifyDTO>> myEvents(@PathVariable int id) {
        User user = service.find(id);

        List<Event> events = eventRepository.findByUser(user);

        List<EventSimplifyDTO> eventsDTO = events.stream()
                .map(obj -> new EventSimplifyDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(eventsDTO);
    }

    @RequestMapping(value="{id}/votes", method= RequestMethod.GET)
    public ResponseEntity<List<VoteUserDTO>> myVotes(@PathVariable int id) {
        User user = service.find(id);

        List<Vote> votes = voteRepository.findByUser(user);

        List<VoteUserDTO> votesDTO = votes.stream()
                .map(obj -> new VoteUserDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(votesDTO);
    }

    @RequestMapping(value="{id}/commentaries", method= RequestMethod.GET)
    public ResponseEntity<List<CommentaryUserDTO>> myCommentaries(@PathVariable int id) {
        User user = service.find(id);

        List<Commentary> votes = commentaryRepository.findByUser(user);

        List<CommentaryUserDTO> commentariesDTO  = votes.stream()
                .map(obj -> new CommentaryUserDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(commentariesDTO);
    }

    @RequestMapping(value="myself", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> getMySelf() {
        UserSS userSS = UserService.authenticated();
        User user = service.find(userSS.getId());
        UserDTO dto = new UserDTO(user);
        return ResponseEntity.ok().body(dto);
    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    public ResponseEntity<UserDTO> loginWithouJWT(@RequestBody CredentialsDTO credentialsDTO) {
        User user = service.loginWithouJWT(credentialsDTO);
        if (user != null) {
            UserDTO dto = new UserDTO(user);
            return ResponseEntity.ok().body(dto);
        } else {
            return ResponseEntity.status(401).body(null);
        }

    }

}
