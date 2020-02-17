package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="event")
public class EventResource {

    @Autowired
    EventService service;

    @RequestMapping(method= RequestMethod.POST)
    public String register(@RequestBody Event obj) {
        service.insert(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public String update(@RequestBody Event obj, @PathVariable int id) {
        service.update(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public Event find(@PathVariable int id) {
        Event obj = service.find(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public Event delete(@PathVariable int id) {
        Event obj = service.delete(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Event> findAll(@PathVariable int id) {
        List<Event> list = service.findAll();
        return list;
    }

}
