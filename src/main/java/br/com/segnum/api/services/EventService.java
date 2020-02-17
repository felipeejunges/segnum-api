package br.com.segnum.api.services;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    public Event insert(Event obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }
}
