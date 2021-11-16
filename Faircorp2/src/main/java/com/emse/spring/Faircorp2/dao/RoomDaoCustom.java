package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Room;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findRoomByName(String name);
}
