package br.com.segnum.api.services;

import br.com.segnum.api.domain.*;
import br.com.segnum.api.domain.Event;
import br.com.segnum.api.dto.event.EventNewDTO;
import br.com.segnum.api.dto.event.EventNewSimplifyDTO;
import br.com.segnum.api.repositories.EventRepository;
import br.com.segnum.api.repositories.EventTypeRepository;
import br.com.segnum.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired LocationService locationService;

    public Event insert(Event obj) {
        obj.setId(0);
        userRepository.save(obj.getUser());
        obj = repo.save(obj);
        return obj;
    }

    public Event update(Event obj) {
        obj = repo.save(obj);
        return obj;
    }

    public Event find(int id) {
        Optional<Event> obj = repo.findById(id);
        return obj.get();
    }

    public List<Event> findAll() {
        List<Event> list = repo.findAll();
        return list;
    }

    public Event delete(int id) {
        Event obj = find(id);
        repo.delete(obj);
        return obj;
    }

    public Event fromDTO(EventNewDTO dto) {
        User user = userRepository.findById(dto.getUserId()).get();
        EventType eventType = eventTypeRepository.findById(dto.getEventTypeId()).get();
        Event event = new Event(0, dto.getName(), dto.getDescription(), eventType, user);
        Location location = new Location(0, dto.getLocationName(), dto.getLocationX(), dto.getLocationY(), event);
        event.setLocation(location);
        return event;
    }

    public Event fromDTO(EventNewSimplifyDTO dto) {
        User user = userRepository.findById(dto.getUserId()).get();
        EventType eventType = eventTypeRepository.findById(dto.getEventTypeId()).get();
        return new Event(0, dto.getName(), dto.getDescription(), eventType, user);
    }
}

