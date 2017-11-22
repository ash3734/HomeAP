package www.ddoc.com.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.dev.sacot41.scviewpager.SCViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ash on 2017-07-15.
 */


public class MPagerAdapter extends SCViewPagerAdapter {
    ArrayList<MainDeviceData> datas;

    public MPagerAdapter(FragmentManager fragmentManager,ArrayList<MainDeviceData> datas) {
        super(fragmentManager);
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Fragment getItem(int position) {
        return HomeFragment.create(datas,position);
    }
}
