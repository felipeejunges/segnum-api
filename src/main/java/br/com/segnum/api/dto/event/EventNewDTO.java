package br.com.segnum.api.dto.event;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.user.UserSimplifyDTO;

import javax.validation.constraints.NotEmpty;

public class EventNewDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;
    private String description;
    private int userId;

    public EventNewDTO() {
    }

    public EventNewDTO(int id, String name, String description, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

