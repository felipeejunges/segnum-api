package br.com.segnum.api.resources;

import br.com.segnum.api.domain.Commentary;
import br.com.segnum.api.services.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="comment")
public class CommentaryResource {

    @Autowired
    CommentaryService service;

    @RequestMapping(method= RequestMethod.POST)
    public String register(@RequestBody Commentary obj) {
        service.insert(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public String update(@RequestBody Commentary obj, @PathVariable int id) {
        service.update(obj);
        return "sucesso";
    }

    @RequestMapping(value="{id}", method= RequestMethod.GET)
    public Commentary find(@PathVariable int id) {
        Commentary obj = service.find(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.DELETE)
    public Commentary delete(@PathVariable int id) {
        Commentary obj = service.delete(id);
        return obj;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Commentary> findAll(@PathVariable int id) {
        List<Commentary> list = service.findAll();
        return list;
    }

}
