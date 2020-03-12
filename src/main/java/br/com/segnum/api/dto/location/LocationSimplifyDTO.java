package br.com.segnum.api.dto.location;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.Location;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.event.EventSimplifyDTO;
import br.com.segnum.api.dto.user.UserSimplifyDTO;

import javax.validation.constraints.NotEmpty;

public class LocationSimplifyDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;
    private String lx;
    private String ly;
    private LocationTypeDTO type;

    public LocationSimplifyDTO() {
    }

    public LocationSimplifyDTO(int id, String name, String lx, String ly, LocationTypeDTO type) {
        this.id = id;
        this.name = name;
        this.lx = lx;
        this.ly = ly;
        this.type = type;
    }

    public LocationSimplifyDTO(Location obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.lx = obj.getLx();
        this.ly = obj.getLy();
        if (obj.getType() != null) this.type = new LocationTypeDTO(obj.getType());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public LocationTypeDTO getType() {
        return type;
    }

    public void setType(LocationTypeDTO type) {
        this.type = type;
    }


}
