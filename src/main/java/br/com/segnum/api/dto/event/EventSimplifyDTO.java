package br.com.segnum.api.dto.event;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.User;

import javax.validation.constraints.NotEmpty;

public class EventSimplifyDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;

    public EventSimplifyDTO() {
    }

    public EventSimplifyDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventSimplifyDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
