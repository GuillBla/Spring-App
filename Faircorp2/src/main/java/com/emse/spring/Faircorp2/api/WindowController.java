package com.emse.spring.Faircorp2.api;

import com.emse.spring.Faircorp2.dao.RoomDao;
import com.emse.spring.Faircorp2.dao.WindowDao;
import com.emse.spring.Faircorp2.dto.WindowDto;
import com.emse.spring.Faircorp2.model.Room;
import com.emse.spring.Faircorp2.model.Window;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{window_id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null);
    }

    @PostMapping // (POST)
    public WindowDto create(@RequestBody WindowDto dto) {
        Room room = roomDao.getById(dto.getRoomId());
        Window window = null;
        if (dto.getId() == null) {
            window = windowDao.save(new Window(room, dto.getName(), dto.getWindowStatus()));
        } else {
            window = windowDao.getById(dto.getId());
            window.setWindowStatus(dto.getWindowStatus());
        }
        return new WindowDto(window);
    }

    @DeleteMapping(path = "/{window_id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}