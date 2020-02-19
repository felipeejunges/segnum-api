package br.com.segnum.api.dto;

import br.com.segnum.api.domain.enums.Profile;

import javax.validation.constraints.NotEmpty;

public class ProfileDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    private String name;

    public ProfileDTO() {
    }

    public ProfileDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProfileDTO(Profile profile) {
        this.id = profile.getCode();
        this.name = profile.getDescription();
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
