package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {
}