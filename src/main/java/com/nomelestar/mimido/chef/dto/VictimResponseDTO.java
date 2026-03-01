package com.nomelestar.mimido.chef.dto;

import java.time.LocalDateTime;

public class VictimResponseDTO {

    private Long id;
    private String name;
    private String family;
    private String status;
    private String location;
    private LocalDateTime deathDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDeathDateTime() {
        return deathDateTime;
    }

    public void setDeathDateTime(LocalDateTime deathDateTime) {
        this.deathDateTime = deathDateTime;
    }
}
