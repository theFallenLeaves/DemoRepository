package llm.com.liwushuo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import llm.com.liwushuo.fragment.FenleiFragment;
import llm.com.liwushuo.fragment.HomeFragment;
import llm.com.liwushuo.fragment.MineFragment;
import llm.com.liwushuo.fragment.TopFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup = null;
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction = null;
    private HomeFragment homeFragment = null;
    private TopFragment topFragment = null;
    private FenleiFragment fenleiFragment = null;
    private MineFragment mineFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.frameLayout_main, homeFragment);
        fragmentTransaction.commit();
    }

    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (topFragment != null) {
            fragmentTransaction.hide(topFragment);
        }
        if (fenleiFragment != null) {
            fragmentTransaction.hide(fenleiFragment);
        }
        if (mineFragment != null) {
            fragmentTransaction.hide(mineFragment);
        }
    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_main);
        radioGroup.check(radioGroup.getChildAt(0).getId());
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fragmentTransaction = fragmentManager.beginTransaction();
        //先隐藏所有fragment
        hideFragments(fragmentTransaction);
        switch (checkedId) {
            case R.id.radioButton_main_home:
                if (homeFragment != null) {
                    fragmentTransaction.show(homeFragment);
                } else {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.frameLayout_main, homeFragment);
                }
                break;
            case R.id.radioButton_main_top:
                if (topFragment != null) {
                    fragmentTransaction.show(topFragment);
                } else {
                    topFragment = new TopFragment();
                    fragmentTransaction.add(R.id.frameLayout_main, topFragment);
                }
                break;
            case R.id.radioButton_main_fenlei:
                if (fenleiFragment != null) {
                    fragmentTransaction.show(fenleiFragment);
                } else {
                    fenleiFragment = new FenleiFragment();
                    fragmentTransaction.add(R.id.frameLayout_main, fenleiFragment);
                }
                break;
            case R.id.radioButton_main_mine:
                if (mineFragment != null) {
                    fragmentTransaction.show(mineFragment);
                } else {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.frameLayout_main, mineFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

}
