package br.com.segnum.api.services;

import br.com.segnum.api.domain.EventType;
import br.com.segnum.api.domain.EventTypeType;
import br.com.segnum.api.domain.Location;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.EventType.EventTypeNewDTO;
import br.com.segnum.api.dto.EventType.EventTypeNewSimplifyDTO;
import br.com.segnum.api.repositories.EventTypeRepository;
import br.com.segnum.api.repositories.EventTypeTypeRepository;
import br.com.segnum.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypeSourceService {

    @Autowired
    private EventTypeRepository repo;


    public EventType find(int id) {
        Optional<EventType> obj = repo.findById(id);
        return obj.get();
    }

    public List<EventType> findAll() {
        List<EventType> list = repo.findAll();
        return list;
    }
}

