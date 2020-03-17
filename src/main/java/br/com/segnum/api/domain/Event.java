package br.com.segnum.api.domain;

import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiIgnore
@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @OneToOne(mappedBy="event", cascade=CascadeType.ALL)
    private Location location;

    @OneToMany(mappedBy="event", cascade=CascadeType.ALL)
    private List<Vote> votes = new ArrayList<>();

    @OneToMany(mappedBy="event", cascade=CascadeType.ALL)
    private List<Commentary> comments = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private EventType eventType;

    @ManyToOne
    @JoinColumn
    private User user;

    public Event() {
    }

    public Event(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Event(int id, String name, String description, EventType eventType, Location location) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.eventType = eventType;
    }

    public Event(int id, String name, String description, EventType eventType, User user) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
        this.eventType = eventType;
    }

    public Event(int id, String name, String description, EventType eventType, Location location, User user) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.user = user;
        this.eventType = eventType;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Commentary> getComments() {
        return comments;
    }

    public void setComments(List<Commentary> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
