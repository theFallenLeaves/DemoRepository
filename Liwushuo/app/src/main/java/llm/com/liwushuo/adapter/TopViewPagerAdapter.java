package llm.com.liwushuo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by llm on 2016/10/4.
 */
public class TopViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment=null;
    private List<String> listTitle=null;
    public TopViewPagerAdapter(FragmentManager fm,List<Fragment> listFragment,List<String> listTitle) {
        super(fm);
        this.listFragment=listFragment;
        this.listTitle=listTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
