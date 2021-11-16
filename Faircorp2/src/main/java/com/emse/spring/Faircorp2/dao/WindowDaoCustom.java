package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Window;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);

    List<Window> findWindowsinBuilding(Long id);

}
