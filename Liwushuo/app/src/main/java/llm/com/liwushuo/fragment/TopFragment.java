package llm.com.liwushuo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import llm.com.liwushuo.R;
import llm.com.liwushuo.adapter.TopViewPagerAdapter;
import llm.com.liwushuo.fragment.top.NewStarFragment;
import llm.com.liwushuo.fragment.top.OriginalFragment;
import llm.com.liwushuo.fragment.top.RecommendFragment;
import llm.com.liwushuo.fragment.top.Top100Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    private TabLayout tabLayout=null;
    private ViewPager viewPager=null;
    private List<String> tabTitle=null;
    private List<Fragment> listFragment=null;
    private TopViewPagerAdapter topViewPagerAdapter=null;

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_top, container, false);
        initView(inflate);
        return inflate;
    }
    private void initView(View view){
        tabLayout= (TabLayout) view.findViewById(R.id.tablayout_topfragment);
        viewPager= (ViewPager) view.findViewById(R.id.viewPager_topfragment);
        listFragment=new ArrayList<>();
        tabTitle=new ArrayList<>();
        initTabLayout();
        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }
    private void initTabLayout(){
        tabTitle.add("每日推荐");
        tabTitle.add("TOP100");
        tabTitle.add("独立原创榜");
        tabTitle.add("新星榜");
        for (int i = 0; i < tabTitle.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTitle.get(i)));
        }
    }
    private void initViewPager(){
        listFragment.add(new RecommendFragment());
        listFragment.add(new Top100Fragment());
        listFragment.add(new OriginalFragment());
        listFragment.add(new NewStarFragment());
        topViewPagerAdapter=new TopViewPagerAdapter(getFragmentManager(),listFragment,tabTitle);
        viewPager.setAdapter(topViewPagerAdapter);
     }

}
