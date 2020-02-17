package br.com.segnum.api.services;

import br.com.segnum.api.domain.Location;
import br.com.segnum.api.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repo;

    public Location insert(Location obj) {
        obj.setId(0);
        obj = repo.save(obj);
        return obj;
    }
}
