package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomByName(String name) {
        String jpql = "select * from Room r where r.name = :name ";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getResultList();
    }

}
