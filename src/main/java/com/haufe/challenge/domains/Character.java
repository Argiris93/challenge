package com.haufe.challenge.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    private String name;
    private int id;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isStatusKnown()  {
        if (!status.equalsIgnoreCase("unknown")) {
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        if (status.equalsIgnoreCase("Alive")) {
            return true;
        }
        return false;
    }

    public boolean isMale() {
        if (gender.equalsIgnoreCase("Male")) {
            return true;
        }
        return false;
    }

    public boolean hasType() {
        if (!type.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isLastLocationKnown() {
        if (!location.getName().equalsIgnoreCase("Unknown")) {
            return true;
        }
        return false;
    }

    public boolean isOriginKnown() {
        if (!origin.getName().equalsIgnoreCase("Unknown")) {
            return true;
        }
        return false;
    }
}
