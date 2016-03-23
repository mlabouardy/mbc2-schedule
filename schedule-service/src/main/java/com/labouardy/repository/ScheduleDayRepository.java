package com.labouardy.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labouardy.model.ScheduleDay;

@Repository
public interface ScheduleDayRepository extends JpaRepository<ScheduleDay, Long>{

	ScheduleDay findByName(String name);

}
