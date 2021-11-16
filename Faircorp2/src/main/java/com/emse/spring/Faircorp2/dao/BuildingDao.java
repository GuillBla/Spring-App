package com.emse.spring.Faircorp2.dao;

import com.emse.spring.Faircorp2.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The methods permitting to display the heaters and the windows of a building are respectively implemented
 * in HeaterDaoImpl and WindowDaoImpl
 */
public interface BuildingDao extends JpaRepository<Building, Long> {
}
