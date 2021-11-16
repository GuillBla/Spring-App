package com.emse.spring.Faircorp2.dto;

import com.emse.spring.Faircorp2.model.Building;

public class BuildingDto {
    private Long id;
    private String name;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
    }

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

}



