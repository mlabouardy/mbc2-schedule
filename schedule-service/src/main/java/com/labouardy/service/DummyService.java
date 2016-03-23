package com.labouardy.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.labouardy.model.ScheduleDay;
import com.labouardy.model.Show;
import com.labouardy.repository.ScheduleDayRepository;
import com.labouardy.repository.ShowRepository;

@Component
public class DummyService implements CommandLineRunner{
	
	@Value("${csv.path}")
	private String CSV_DIR;
	
	private ShowSetMapper mapper=new ShowSetMapper();
	private Logger logger=Logger.getLogger("DummyService");
	
	@Autowired
	private ScheduleDayRepository scheduleRepository;
	
	@Autowired
	private ShowRepository showRepository;

	private static final String days[]={"Monday","Tuesday","Wednesday","Tuersday","Friday","Saturday","Sunday"};
	
	@Override
	public void run(String... arg0) throws Exception {
		FileReader fr=new FileReader(new File(CSV_DIR));
		BufferedReader br=new BufferedReader(fr);
		String line;
		int index=0;
		int day=0;
		List<Show> shows=new ArrayList();
		while((line=br.readLine())!=null){
			String[] data=line.split(",");
			if(index!=0){
				Show show=mapper.mapFieldSet(data);
				showRepository.save(show);
				shows.add(show);
				logger.info("Processing: "+show);
				if(shows.size()==13){
					ScheduleDay scheduleDay=new ScheduleDay();
					scheduleDay.setDate(Calendar.getInstance().getTime());
					scheduleDay.setName(days[day]);
					scheduleDay.setShows(shows);
					scheduleRepository.save(scheduleDay);
					shows=new ArrayList();
					day++;
				}
			}
			index++;
		}
	}

}
