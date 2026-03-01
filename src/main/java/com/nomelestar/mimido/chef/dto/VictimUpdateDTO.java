package com.nomelestar.mimido.chef.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class VictimUpdateDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String family;

    @NotBlank
    private String status;

    @NotBlank
    private String location;

    @NotNull
    private LocalDateTime deathDateTime;

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
