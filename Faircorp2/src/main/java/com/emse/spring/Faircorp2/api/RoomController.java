package com.emse.spring.Faircorp2.api;


import com.emse.spring.Faircorp2.dao.BuildingDao;
import com.emse.spring.Faircorp2.dao.HeaterDao;
import com.emse.spring.Faircorp2.dao.RoomDao;
import com.emse.spring.Faircorp2.dao.WindowDao;
import com.emse.spring.Faircorp2.dto.HeaterDto;
import com.emse.spring.Faircorp2.dto.RoomDto;
import com.emse.spring.Faircorp2.dto.WindowDto;
import com.emse.spring.Faircorp2.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {
    private final BuildingDao buildingDao;
    private final WindowDao windowDao;
    private final RoomDao roomDao;
    private final HeaterDao heaterDao;

    public RoomController(WindowDao windowDao, RoomDao roomDao, HeaterDao heaterDao, BuildingDao buildingDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping // (GET) send a room list
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{room_id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null);
    }

    @PutMapping(path = "/{room_id}/switchWindow")
    public WindowDto switchStatusw(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
        return new WindowDto(window);
    }

    @PostMapping // (POST)
    public RoomDto create(@RequestBody RoomDto dto) {
        Building building = buildingDao.getById(dto.getBuildingId());
        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName()));
        } else {
            room = roomDao.getById(dto.getId());
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{room_id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{room_id}/switchHeaters")
    public HeaterDto switchStatush(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        return new HeaterDto(heater);

    }

}