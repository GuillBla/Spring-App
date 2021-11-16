package com.emse.spring.Faircorp2.api;


import com.emse.spring.Faircorp2.dao.HeaterDao;
import com.emse.spring.Faircorp2.dao.RoomDao;
import com.emse.spring.Faircorp2.dto.HeaterDto;
import com.emse.spring.Faircorp2.model.Heater;
import com.emse.spring.Faircorp2.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping // (GET) send heaters list
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{heater_id}") // (GET) read a heater
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }


    @PostMapping // (POST) add a heater
    public HeaterDto create(@RequestBody HeaterDto dto) {
        Room room = roomDao.getById(dto.getRoomId());
        Heater heater = null;
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(room, dto.getName(), dto.getHeaterStatus()));
        } else {
            heater = heaterDao.getById(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
        }
        return new HeaterDto(heater);
    }


    @DeleteMapping(path = "/{heater_id}") // (DELETE) delete a heater
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }

}
