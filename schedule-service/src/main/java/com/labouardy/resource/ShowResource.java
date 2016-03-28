package com.labouardy.resource;


import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labouardy.model.Message;
import com.labouardy.model.ScheduleDay;
import com.labouardy.model.Show;
import com.labouardy.repository.ScheduleDayRepository;
import com.labouardy.repository.ShowRepository;

@RestController
public class ShowResource {
	
	@Autowired
	private ScheduleDayRepository scheduleRepository;
	
	private static final String days[]={"Monday","Tuesday","Wednesday","Tuersday","Friday","Saturday","Sunday"};
	
	@RequestMapping(value="/schedules",method=RequestMethod.GET, produces="application/json")
	public Collection<ScheduleDay> getWeekShows(){
		return scheduleRepository.findAll();
	}
	
	@RequestMapping(value="/schedule",method=RequestMethod.GET, produces="application/json")
	public ResponseEntity getDayShows(@RequestParam(value="day",defaultValue="Monday") String day){
		final String upDay=day.substring(0, 1).toUpperCase() + day.substring(1);
		boolean validDay=Stream.of(days).anyMatch(d -> d.equals(upDay));
		if(!validDay){
			return new ResponseEntity(new Message(401,"Invalid request param"),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(scheduleRepository.findByName(upDay), HttpStatus.OK);
	}

}
