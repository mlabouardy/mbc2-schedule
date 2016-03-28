package labouardy.com.mbc2schedule.handler;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import labouardy.com.mbc2schedule.R;
import labouardy.com.mbc2schedule.model.Show;

/**
 * Created by mlabouardy on 28/03/16.
 */
public class ShowAdapter extends BaseAdapter {

    private Activity activity;
    private List<Show> shows;

    @Bind(R.id.eg)
    TextView egTV;

    @Bind(R.id.ksa)
    TextView ksaTV;

    @Bind(R.id.description)
    TextView descriptionTV;

    @Bind(R.id.name)
    TextView nameTV;

    public ShowAdapter(Activity activity, List<Show> shows){
        this.activity=activity;
        this.shows=shows;
    }

    @Override
    public int getCount() {
        return shows.size();
    }

    @Override
    public Object getItem(int i) {
        return shows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.show, null);
        }
        ButterKnife.bind(this, view);

        Show show=shows.get(i);
        ksaTV.setText(show.getKsa());
        egTV.setText(show.getEg());
        descriptionTV.setText(show.getDescription());
        nameTV.setText(show.getName());
        return view;
    }
}
