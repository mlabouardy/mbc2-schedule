package labouardy.com.mbc2schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import labouardy.com.mbc2schedule.handler.Storage;
import labouardy.com.mbc2schedule.model.Schedule;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by mlabouardy on 28/03/16.
 */
public class ShowsFragment extends Fragment implements Callback<Schedule>{

    public ShowsFragment build(String day){
        ShowsFragment fragment=new ShowsFragment();
        Bundle args = new Bundle();
        args.putString("day",day);
        fragment.setArguments(args);
        return fragment;
    }


    public ShowsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shows, container, false);
        Bundle args = getArguments();
        String day=args.getString("day");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vps259935.ovh.net:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        ScheduleAPI scheduleAPI = retrofit.create(ScheduleAPI.class);
        Call<Schedule> call = scheduleAPI.getDayShows(day);
        //asynchronous call
        call.enqueue(this);

        TextView name=(TextView) rootView.findViewById(R.id.name);
        TextView date=(TextView) rootView.findViewById(R.id.date);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onResponse(Response<Schedule> response, Retrofit retrofit) {
        Toast.makeText(this.getActivity(),"Size:"+response.body().getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable t) {

    }
}