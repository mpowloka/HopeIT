package org.hopeit.charapp.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import org.hopeit.charapp.R;
import org.hopeit.charapp.fragments.AboutFragment;
import org.hopeit.charapp.fragments.ArchiveFragment;
import org.hopeit.charapp.fragments.FundraisingFragment;
import org.hopeit.charapp.fragments.InspirationFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivityFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private String tabTitles[];
    private Context context;
    private Map<String, Fragment> fragmentMap;

    private int[] imageResId = { R.drawable.icon_hand};

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
//        TextView tv = (TextView) v.findViewById(R.id.custom_text_tab);
//        tv.setText(tabTitles[position]);
        ImageView img = (ImageView) v.findViewById(R.id.custom_image_tab);
        img.setImageResource(imageResId[position]);
        return v;
    }

    public MainActivityFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);

        this.context = context;
        tabTitles = new String[] { context.getResources().getString(R.string.mainactivity_inspiration),
                context.getResources().getString(R.string.mainactivity_archive),
                context.getResources().getString(R.string.mainactivity_about),
                context.getResources().getString(R.string.mainactivity_fundraising)};

        fragmentMap = new HashMap<>();
        fragmentMap.put(tabTitles[0], InspirationFragment.newInstance(1));
        fragmentMap.put(tabTitles[1], ArchiveFragment.newInstance(2));
        fragmentMap.put(tabTitles[2], AboutFragment.newInstance(3));
        fragmentMap.put(tabTitles[3], FundraisingFragment.newInstance(4));


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
