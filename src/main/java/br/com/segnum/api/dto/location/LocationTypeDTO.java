package br.com.segnum.api.dto.location;

import br.com.segnum.api.domain.enums.LocationType;

import javax.validation.constraints.NotEmpty;

public class LocationTypeDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    private String name;

    public LocationTypeDTO() {
    }

    public LocationTypeDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocationTypeDTO(LocationType type) {
        this.id = type.getCode();
        this.name = type.name();
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
