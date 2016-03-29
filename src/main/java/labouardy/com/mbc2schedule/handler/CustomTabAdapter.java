package labouardy.com.mbc2schedule.handler;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by mlabouardy on 29/03/16.
 */
public class CustomTabAdapter implements ActionBar.TabListener {

    private ViewPager mViewPager;

    public CustomTabAdapter(ViewPager mViewPager){
        this.mViewPager=mViewPager;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
