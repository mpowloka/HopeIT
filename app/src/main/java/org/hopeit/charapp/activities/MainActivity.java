package org.hopeit.charapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import org.hopeit.charapp.utils.MainActivityFragmentPagerAdapter;
import org.hopeit.charapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainActivityFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.menuTabLayout);
        tabLayout.setupWithViewPager(viewPager);

        View view = (RelativeLayout) findViewById(R.id.button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMakeOrHelpActivity();
            }
        });


    }

    public void toMakeOrHelpActivity() {
        Intent intent = new Intent(this, MakerOrHelpActivity.class);
        startActivity(intent);
    }
}
