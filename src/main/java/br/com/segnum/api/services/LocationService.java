package br.com.segnum.api.services;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.domain.Location;
import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repo;

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
}
