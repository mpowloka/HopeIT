package org.hopeit.charapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import org.hopeit.charapp.R;
import org.hopeit.charapp.utils.MainActivityFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        MainActivityFragmentPagerAdapter pagerAdapter =
                new MainActivityFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setAdapter(new MainActivityFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.menuTabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(
                ContextCompat.getColor(getApplicationContext(), R.color.colorWhite),
                ContextCompat.getColor(getApplicationContext(), R.color.colorWhite)
        );

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if (i==0){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));}
        }

        View view = (RelativeLayout) findViewById(R.id.btn_submit);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miMail:
                toMessagesActivity();
                return true;
            case R.id.miProfile:
                toProfileActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void toMessagesActivity() {
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }

    public void toProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
