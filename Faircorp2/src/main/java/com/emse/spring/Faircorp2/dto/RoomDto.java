package com.emse.spring.Faircorp2.dto;

import com.emse.spring.Faircorp2.model.Room;

public class RoomDto {

    private Long id;
    private String name;
    private Long buildingId;
    private String buildingName;
    private Integer floor;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.buildingName = room.getBuilding().getName();
        this.buildingId = room.getBuilding().getId();
        this.floor = room.getFloor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
