package br.com.segnum.api.dto.location;

import javax.validation.constraints.NotEmpty;

public class LocationEventNewDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;
    private String lx;
    private String ly;
    private int eventId;

    public LocationEventNewDTO() {
    }

    public LocationEventNewDTO(int id, String name, String lx, String ly, int eventId) {
        this.id = id;
        this.name = name;
        this.lx = lx;
        this.ly = ly;
        this.eventId = eventId;
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }


}
