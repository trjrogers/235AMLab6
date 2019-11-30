package com.example.letsmakeadeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    TextView doorReveal;
    Button backToMain;
    Integer numDoor;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        this.doorReveal = findViewById(R.id.door_reveal);
        this.backToMain = findViewById(R.id.back_to_main);
        this.backToMain.setOnClickListener(this);

        Intent intent = getIntent();
        numDoor = intent.getIntExtra("door", 0);
        s = "";
        switch (numDoor) {
            case 1:
                s = "Behind door number 1 is a: ";
                break;
            case 2:
                s = "Behind door number 2 is a: ";
                break;
            case 3:
                s = "Behind door number 3 is a: ";
                break;
        }
        Integer x = numberGen();
        String what = whatToReveal(x);

        s = s + what;

        doorReveal.setText(s);
    }

    public String whatToReveal(int number) {
        String s = "";
        switch (number) {
            case 1:
                s = "brand new Prius!";
                break;
            case 2:
                s = "skunk!?";
                break;
            case 3:
                s = "goat???";
                break;
        }
        return s;
    }

    public int numberGen() {
        return (int)(Math.random() * (3) + 1);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.back_to_main:
//                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("string", s);
                intent.putExtra("doorNumber", numDoor);
                this.startActivity(intent);
                break;
        }
    }
}
