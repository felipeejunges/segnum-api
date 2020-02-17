package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Location;
import br.com.segnum.api.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="location")
public class LocationResource {

    @Autowired
    LocationService service;

    @RequestMapping(method= RequestMethod.POST)
    public String register(@RequestBody Location obj) {
        service.insert(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public String update(@RequestBody Location obj, @PathVariable int id) {
        service.update(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public Location find(@PathVariable int id) {
        Location obj = service.find(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public Location delete(@PathVariable int id) {
        Location obj = service.delete(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Location> findAll(@PathVariable int id) {
        List<Location> list = service.findAll();
        return list;
    }

}
