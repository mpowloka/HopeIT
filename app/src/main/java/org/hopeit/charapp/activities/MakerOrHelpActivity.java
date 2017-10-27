package org.hopeit.charapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.hopeit.charapp.R;
import org.hopeit.charapp.activities.HelpActivity;
import org.hopeit.charapp.activities.MakerActivity;

public class MakerOrHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maker_or_help);



    }

    public void toHelpActivity(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    public void toMakerActivity(){
        Intent intent = new Intent(this, MakerActivity.class);
        startActivity(intent);
    }
}
