package br.com.segnum.api.dto.eventType;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.EventType;

import javax.validation.constraints.NotEmpty;

public class EventTypeSimplifyDTO {
    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;

    public EventTypeSimplifyDTO() {
    }

    public EventTypeSimplifyDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventTypeSimplifyDTO(EventType eventType) {
        this.id = eventType.getId();
        this.name = eventType.getName();
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
