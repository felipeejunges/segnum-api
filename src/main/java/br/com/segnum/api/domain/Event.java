package br.com.segnum.api.domain;

import br.com.segnum.api.domain.enums.Profile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

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
    private List<Vote> comments = new ArrayList<>();

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

    public Event(int id, String name, String description, Location location) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public Event(int id, String name, String description, User user) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public Event(int id, String name, String description, Location location, User user) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.user = user;
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

    public List<Vote> getComments() {
        return comments;
    }

    public void setComments(List<Vote> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
