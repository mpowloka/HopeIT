package org.hopeit.charapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MakerOrHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maker_or_help);

        View viewHelp = (RelativeLayout) findViewById(R.id.help_with_money);
        viewHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHelpActivity();
            }
        });

        View viewMaker = (RelativeLayout) findViewById(R.id.mail_us);
        viewMaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMakerActivity();
            }
        });
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
