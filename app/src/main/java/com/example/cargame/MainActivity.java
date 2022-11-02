package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button identifyTheCarManufacturer,hangman,chooseTheRightCar, nameTheCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        identifyTheCarManufacturer=findViewById(R.id.b_mainPage_identifyTheManufacturer);
        hangman=findViewById(R.id.b_mainPage_hangman);
        chooseTheRightCar=findViewById(R.id.b_mainPage_ChooseTheRightCar);
        nameTheCar=findViewById(R.id.b_mainPage_nameTheCar);

        identifyTheCarManufacturer.setOnClickListener(this);
        hangman.setOnClickListener(this);
        chooseTheRightCar.setOnClickListener(this);
        nameTheCar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.b_mainPage_identifyTheManufacturer:
                startActivity(new Intent(this,Identify_the_manufacturer.class));
                break;
            case R.id.b_mainPage_ChooseTheRightCar:
                startActivity(new Intent(this,Choose_the_right_car.class));
                break;
            case R.id.b_mainPage_hangman:
                startActivity(new Intent(this,Hangman.class));
                break;
            case R.id.b_mainPage_nameTheCar:
                startActivity(new Intent(this,Name_the_car.class));
                break;
        }
    }
}