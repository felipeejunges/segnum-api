package br.com.segnum.api.dto.event;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.dto.eventType.EventTypeSimplifyDTO;
import br.com.segnum.api.dto.location.LocationSimplifyDTO;
import br.com.segnum.api.dto.user.UserSimplifyDTO;

import javax.validation.constraints.NotEmpty;

public class EventDTO {

    @NotEmpty(message="Preenchimento obrigatório")
    private int id;
    @NotEmpty(message="Preenchimento obrigatório")
    private String name;
    private String description;
    private UserSimplifyDTO user;
    private EventTypeSimplifyDTO eventTypeDTO;
    private LocationSimplifyDTO locationDTO;

    public EventDTO() {
    }

    public EventDTO(int id, String name, String description, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = new UserSimplifyDTO(user);
    }

    public EventDTO(int id, String name, String description, UserSimplifyDTO user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.user = new UserSimplifyDTO(event.getUser());
        this.locationDTO = new LocationSimplifyDTO(event.getLocation());
        this.eventTypeDTO = new EventTypeSimplifyDTO(event.getEventType());
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

    public UserSimplifyDTO getUser() {
        return user;
    }

    public void setUser(UserSimplifyDTO user) {
        this.user = user;
    }

    public LocationSimplifyDTO getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationSimplifyDTO locationDTO) {
        this.locationDTO = locationDTO;
    }

    public EventTypeSimplifyDTO getEventTypeDTO() {
        return eventTypeDTO;
    }

    public void setEventTypeDTO(EventTypeSimplifyDTO eventTypeDTO) {
        this.eventTypeDTO = eventTypeDTO;
    }
}
