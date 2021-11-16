package com.emse.spring.Faircorp2.api;

import com.emse.spring.Faircorp2.dao.BuildingDao;
import com.emse.spring.Faircorp2.dao.RoomDao;
import com.emse.spring.Faircorp2.dto.BuildingDto;
import com.emse.spring.Faircorp2.model.Building;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao) {
        this.buildingDao = buildingDao;
    }

    @GetMapping // (GET) send buildings list
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{building_id}") //(GET) read a building
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null); // (7)
    }

    @PostMapping // (POST) add a building
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() == null) {
            building = buildingDao.save(new Building(dto.getName()));
        } else {
            building = buildingDao.getById(dto.getId());
        }
        return new BuildingDto(building);
    }

    @DeleteMapping(path = "/{building_id}") // (DELETE) delete a building
    public void delete(@PathVariable Long id) {
        buildingDao.deleteById(id);
    }

}