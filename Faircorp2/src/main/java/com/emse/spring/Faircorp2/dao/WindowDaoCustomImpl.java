package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Window;
import com.emse.spring.Faircorp2.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public List<Window> findWindowsinBuilding(Long id) {//Displays all the windows in the building of id  : id
        String jpql = "select w from Window w where w.room.building.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }

}
