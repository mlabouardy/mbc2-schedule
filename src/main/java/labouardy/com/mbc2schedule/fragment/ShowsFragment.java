package labouardy.com.mbc2schedule.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import labouardy.com.mbc2schedule.R;
import labouardy.com.mbc2schedule.rest.ScheduleAPI;
import labouardy.com.mbc2schedule.handler.ShowAdapter;
import labouardy.com.mbc2schedule.model.Schedule;
import labouardy.com.mbc2schedule.model.Show;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by mlabouardy on 28/03/16.
 */
public class ShowsFragment extends Fragment implements Callback<Schedule>{
    @Bind(R.id.shows)
    ListView lv;

    private List<Show> shows=Collections.emptyList();
    private ShowAdapter adapter;

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

        ButterKnife.bind(this, rootView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vps259935.ovh.net:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        ScheduleAPI scheduleAPI = retrofit.create(ScheduleAPI.class);
        Call<Schedule> call = scheduleAPI.getDayShows(day);
        //asynchronous call
        call.enqueue(this);

        adapter=new ShowAdapter(this.getActivity(), shows);
        lv.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onResponse(Response<Schedule> response, Retrofit retrofit) {
        shows=response.body().getShows();
        adapter=new ShowAdapter(this.getActivity(), shows);
        lv.setAdapter(adapter);
    }

    @Override
    public void onFailure(Throwable t) {

    }
}