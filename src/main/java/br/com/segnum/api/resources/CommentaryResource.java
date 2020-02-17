package br.com.segnum.api.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="comment")
public class CommentaryResource {

    @RequestMapping(method= RequestMethod.GET)
    public String test() {
        return "teste";
    }

}
