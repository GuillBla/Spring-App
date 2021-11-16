package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface WindowDao extends JpaRepository<Window,Long>,WindowDaoCustom{

    @Modifying
    @Query("delete from Window w where w.room.id = :id")
    /**
     * Deletes the windows of the room of id :
     * @param id :id
     */
    void deleteByRoom(@Param("id") Long id);
}

