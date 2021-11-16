package com.emse.spring.Faircorp2.model;

import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Long power;

    @ManyToOne
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(Room room, String name, HeaterStatus status) {
        this.heaterStatus = status;
        this.name = name;
        this.room = room;
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

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
