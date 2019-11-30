package com.example.letsmakeadeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button door1;
    Button door2;
    Button door3;


//    SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.door1 = findViewById(R.id.door_one);
        this.door1.setOnClickListener(this);
        this.door2 = findViewById(R.id.door_two);
        this.door2.setOnClickListener(this);
        this.door3 = findViewById(R.id.door_three);
        this.door3.setOnClickListener(this);

        Intent intent = getIntent();

        Integer door = intent.getIntExtra("doorNumber",0);
        String s = intent.getStringExtra("string");

        switch(door) {
            case 1:
                door1.setText(s);
                door1.setEnabled(false);
                break;
            case 2:
                door2.setText(s);
                door2.setEnabled(false);
                break;
            case 3:
                door3.setText(s);
                door3.setEnabled(false);
                break;
            case 0:
                break;
        }
//        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

//    @Override
//    protected void onPause(){
//        SharedPreferences.Editor editor = savedValues.edit();
//
//        editor.putString("door_one_string", String.valueOf(door1.getText()));
//        editor.putString("door_two_string", String.valueOf(door2.getText()));
//        editor.putString("door_three_string", String.valueOf(door3.getText()));
//        editor.commit();
//        super.onPause();
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        this.door1.setText(savedValues.getString("door_one_string", "Door number 1"));
//        this.door2.setText(savedValues.getString("door_two_string", "Door number 2"));
//        this.door3.setText(savedValues.getString("door_three_string", "Door number 3"));
//    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.door_one:
//                Toast.makeText(this, "Door 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra("door", 1);
                startActivity(intent);
                break;
            case R.id.door_two:
//                Toast.makeText(this, "Door 2", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, Activity2.class);
                intent.putExtra("door", 2);
                startActivity(intent);
                break;
            case R.id.door_three:
//                Toast.makeText(this, "Door 3", Toast.LENGTH_LONG).show();
                intent = new Intent(this, Activity2.class);
                intent.putExtra("door", 3);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
