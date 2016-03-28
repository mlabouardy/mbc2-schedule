package labouardy.com.mbc2schedule;

import java.util.Collection;

import labouardy.com.mbc2schedule.model.Schedule;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by mlabouardy on 28/03/16.
 */
public interface ScheduleAPI {

    @GET("/schedule")
    Call<Schedule> getDayShows(@Query("day") String day);
}
