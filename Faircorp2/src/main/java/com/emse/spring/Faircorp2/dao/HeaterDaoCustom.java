package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Heater;

import java.util.List;

public interface HeaterDaoCustom {
    List<Heater> findHeatersinBuilding(Long id);
}
