package br.com.segnum.api.services;

import br.com.segnum.api.domain.*;
import br.com.segnum.api.domain.enums.LocationType;
import br.com.segnum.api.dto.location.LocationEventNewDTO;
import br.com.segnum.api.dto.location.LocationUserNewDTO;
import br.com.segnum.api.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repo;
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;

    public Location insert(Location obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }

    public Location update(Location obj) {
        obj = repo.save(obj);
        return obj;
    }

    public Location find(int id) {
        Optional<Location> obj = repo.findById(id);
        return obj.get();
    }

    public List<Location> findAll() {
        List<Location> list = repo.findAll();
        return list;
    }

    public Location delete(int id) {
        Location obj = find(id);
        repo.delete(obj);
        return obj;
    }

    public Location fromDTO(LocationUserNewDTO dto) {
        User user = userService.find(dto.getUserId());
        return new Location(0, dto.getName(), dto.getLx(), dto.getLy(), dto.getType(), user);
    }

    public Location fromDTO(LocationEventNewDTO dto) {
        Event event = eventService.find(dto.getEventId());
        return new Location(0, dto.getName(), dto.getLx(), dto.getLy(), event);
    }
}
