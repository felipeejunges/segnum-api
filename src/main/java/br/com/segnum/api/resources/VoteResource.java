package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Vote;
import br.com.segnum.api.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="vote")
public class VoteResource {

    @Autowired
    VoteService service;

    @RequestMapping(method= RequestMethod.POST)
    public String register(@RequestBody Vote obj) {
        service.insert(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public String update(@RequestBody Vote obj, @PathVariable int id) {
        service.update(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public Vote find(@PathVariable int id) {
        Vote obj = service.find(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public Vote delete(@PathVariable int id) {
        Vote obj = service.delete(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Vote> findAll(@PathVariable int id) {
        List<Vote> list = service.findAll();
        return list;
    }

}
