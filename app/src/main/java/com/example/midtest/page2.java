package com.example.midtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        TextView name =(TextView) findViewById(R.id.textView4);
        TextView score =(TextView) findViewById(R.id.textView5);

        Intent view = getIntent();

        name.setText(view.getStringExtra("name"));
        score.setText(view.getStringExtra("score"));
    }
}
