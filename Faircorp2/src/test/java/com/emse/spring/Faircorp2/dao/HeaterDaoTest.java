package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Heater;
import com.emse.spring.Faircorp2.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {

    @Autowired
    private HeaterDao heaterDao;

    @Autowired
    private HeaterDaoCustom heaterDaoC;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldDeleteHeatersRoom() {
        Room room = roomDao.getById(-10L);
        List<Long> roomIds = room.getHeaters().stream().map(Heater::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        heaterDao.deleteByRoom(-10L);
        List<Heater> result = heaterDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindallHeatersinBuilding() {
        List<Heater> result = heaterDaoC.findHeatersinBuilding(155L);
        Assertions.assertThat(result)
                .hasSize(2);
    }

}
