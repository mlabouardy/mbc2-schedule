package labouardy.com.mbc2schedule;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by mlabouardy on 28/03/16.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public static final String DAYS[]={"Monday","Tuesday","Wednesday","Tuersday","Friday","Saturday","Sunday"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new ShowsFragment().build(DAYS[position]);
    }

    @Override
    public int getCount() {
        return DAYS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        return DAYS[position];
    }
}
