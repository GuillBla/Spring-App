package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Heater;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> findHeatersinBuilding(Long id) { //Displays all the heaters in the building of id  : id
        String jpql = "select h from Heater h where h.room.building.id = :id";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .getResultList();
    }

}
