package com.example.midtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name = (EditText) findViewById(R.id.editTextName);
        final EditText score = (EditText) findViewById(R.id.editTextScore);
        Button find = (Button) findViewById(R.id.buttonFindGrade);
        Button exit = (Button) findViewById(R.id.buttonExit);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(name.getText().length() == 0 || score.getText().length() == 0){
                    name.setError("ป้อนชื่อ");
                    score.setError("ป้อนคะแนน");
                }else {
                    String grade;
                    int x = Integer.parseInt(score.getText().toString());
                    if(x >= 80){
                        grade = "A";
                    }else if(x >= 70){
                        grade = "B";
                    }else if(x >=  60){
                        grade = "C";
                    }else if(x >= 50){
                        grade = "D";
                    }else {
                        grade = "F";
                    }
                    Intent intent = new Intent(MainActivity.this,page2.class);
                    intent.putExtra("name",name.getText().toString());
                    intent.putExtra("score",grade);
                    startActivity(intent);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        score.setText("");
                        name.setText("");
                        name.requestFocus();

                    }
                }
                );
                dialog.setNegativeButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.show();

            }
        });

    }
}
