package org.hopeit.charapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

public class MainActivityFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[];
    private Context context;
    private Map<String, Fragment> fragmentMap;

    public MainActivityFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);

        this.context = context;
        tabTitles = new String[] { context.getResources().getString(R.string.mainactivity_inspiration),
                context.getResources().getString(R.string.mainactivity_archive),
                context.getResources().getString(R.string.mainactivity_about) };

        fragmentMap = new HashMap<>();
        fragmentMap.put(tabTitles[0], InspirationFragment.newInstance(1));
        fragmentMap.put(tabTitles[1], ArchiveFragment.newInstance(2));
        fragmentMap.put(tabTitles[2], AboutFragment.newInstance(3));
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentMap.get(tabTitles[position]);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
