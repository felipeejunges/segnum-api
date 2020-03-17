package br.com.segnum.api.services;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.Location;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.location.LocationNewDTO;
import br.com.segnum.api.repositories.EventRepository;
import br.com.segnum.api.repositories.LocationRepository;
import br.com.segnum.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repo;
    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    public Location insert(Location obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }

    public Location insertUserLocation(LocationNewDTO dto, int userId) {
        User user = userRepository.findById(userId).get();

        Location obj = fromDTO(dto, user);
        user.getMyLocations().add(obj);

        obj = insert(obj);
        userRepository.save(user);

        return obj;
    }

    public Location insertEventLocation(LocationNewDTO dto, int eventId) {
        Event event = eventRepository.findById(eventId).get();

        Location obj = fromDTO(dto, event);
        event.setLocation(obj);

        obj = insert(obj);
        eventRepository.save(event);

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

    public Location fromDTO(LocationNewDTO dto, Event event) {
        return new Location(0, dto.getName(), dto.getLx(), dto.getLy(), event);
    }

    public Location fromDTO(LocationNewDTO dto, User user) {
        return new Location(0, dto.getName(), dto.getLx(), dto.getLy(), dto.getType(), user);
    }
}

