package br.com.segnum.api.services;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    public Event insert(Event obj) {
        obj.setId(0);
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
}
