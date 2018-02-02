package com.actigage.whitelabelingdemo;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
import fragments.YellowFragment1;
import fragments.YellowFragment2;
=======
import fragments.RedFragment1;
import fragments.RedFragment2;
import fragments.RedFragment3;

>>>>>>> feature/feature_red_flavor
=======
import fragments.GreenFragment1;
import fragments.GreenFragment2;
import fragments.GreenFragment3;
import fragments.GreenFragment4;
>>>>>>> feature/feature_green_flavor

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
<<<<<<< HEAD
<<<<<<< HEAD
        setupViewPager(viewPager);
        setupTabIcons();
=======
        setupViewPagerAndTab(viewPager);
>>>>>>> feature/feature_red_flavor
=======
        setupViewPager(viewPager);
>>>>>>> feature/feature_green_flavor
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
<<<<<<< HEAD

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
<<<<<<< HEAD
        adapter.addFragment(new YellowFragment1(), "YELLOW1");
        adapter.addFragment(new YellowFragment2(), "YELLOW2");
=======
    private void setupViewPagerAndTab(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RedFragment1(), "RED1");
        adapter.addFragment(new RedFragment2(), "RED2");
        adapter.addFragment(new RedFragment3(), "RED3");
>>>>>>> feature/feature_red_flavor
=======
        adapter.addFragment(new GreenFragment1(), "GREEN1");
        adapter.addFragment(new GreenFragment2(), "GREEN2");
        adapter.addFragment(new GreenFragment3(), "GREEN3");
        adapter.addFragment(new GreenFragment4(), "GREEN4");
>>>>>>> feature/feature_green_flavor
        viewPager.setAdapter(adapter);
        setupTabIcons();
    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.agenda);
        tabLayout.getTabAt(1).setIcon(R.drawable.sponsors);
        tabLayout.getTabAt(2).setIcon(R.drawable.speakers);
<<<<<<< HEAD
    }
<<<<<<< HEAD
    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(R.drawable.agenda);
        tabLayout.getTabAt(1).setIcon(R.drawable.speakers);
    }

=======
>>>>>>> feature/feature_red_flavor
=======
        tabLayout.getTabAt(3).setIcon(R.drawable.ticket);
    }
>>>>>>> feature/feature_green_flavor
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
