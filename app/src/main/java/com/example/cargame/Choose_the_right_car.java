package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

public class Choose_the_right_car extends AppCompatActivity {
    ImageView firstCar, secondCar;
    Button tryAgain;
    TextView carName,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_the_right_car);
        String[] carNames = {"Audi","Bentley","BMW","Bugatti","Chevrolet","Citroen","Dacia","Ferrari","Fiat","Ford","FordMustang","Honda","Hyundai",
                "Jeep","KiaMotors","Lamborghini","LandRover","Mercedes","Mitsubishi","Nissan","Opel","Peugeot","Porsche","Renault","Skoda",
                "Suzuki","Tesla","Toyota","Volkswagen","Volvo"}; // car names array
        int[] randomCar = {
                R.drawable.audi,
                R.drawable.bentley,
                R.drawable.bmw,
                R.drawable.bugatti,
                R.drawable.chevrolet,
                R.drawable.citroen,
                R.drawable.dacia,
                R.drawable.ferrari,
                R.drawable.fiat,
                R.drawable.ford,
                R.drawable.fordmustang,
                R.drawable.honda,
                R.drawable.hyundai,
                R.drawable.jeep,
                R.drawable.kiamotors,
                R.drawable.lamborghini,
                R.drawable.landrover,
                R.drawable.mercedes,
                R.drawable.mitsubishi,
                R.drawable.nissan,
                R.drawable.opel,
                R.drawable.peugeot,
                R.drawable.porsche,
                R.drawable.renault,
                R.drawable.skoda,
                R.drawable.suzuki,
                R.drawable.tesla,
                R.drawable.toyota,
                R.drawable.volkswagen,
                R.drawable.volvo
        };


        firstCar=findViewById(R.id.iv_chooseTheRightCar_firstCar);
        secondCar=findViewById(R.id.iv_chooseTheRightCar_secondCar);
        tryAgain=findViewById(R.id.b_chooseTheRightCar_tryAgain);
        tryAgain.setVisibility(View.INVISIBLE);
        carName=findViewById(R.id.tv_chooseTheRightCar_carName);
        result=findViewById(R.id.tv_chooseTheRightCar_result);
        result.setVisibility(View.INVISIBLE);
        Random random = new Random();
        int rdm1 = random.nextInt(10);
        int rdm2 = random.nextInt(10)+20;
        //int[] array={rdm1,rdm2}; // it is needed for rdm4. We will take a random name from these 3 choices
        firstCar.setImageResource(randomCar[rdm1]);
        secondCar.setImageResource(randomCar[rdm2]);
        String firstCarName = carNames[rdm1];
        String secondCarName=carNames[rdm2];
        //carName.setText(secondCarName);
        String car;
        int randomName = random.nextInt(2); //randam name
        if(randomName == 0)
            car=firstCarName;
        else
            car=secondCarName;
        carName.setText("Which car is made by " + car + "?");

        firstCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setVisibility(View.VISIBLE);
                tryAgain.setVisibility(View.VISIBLE);
                carName.setVisibility(View.INVISIBLE);
                if(car == firstCarName){
                result.setText("Correct!");
                result.setTextColor(Color.GREEN);}
                else{result.setText("Wrong!");
                    result.setTextColor(Color.RED);}
            }
        });
        secondCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setVisibility(View.VISIBLE);
                tryAgain.setVisibility(View.VISIBLE);
                carName.setVisibility(View.INVISIBLE);
                if(car == secondCarName){
                    result.setText("Correct!");
                    result.setTextColor(Color.GREEN);}
                else{result.setText("Wrong!");
                    result.setTextColor(Color.RED);}
            }

        });
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });
    }
    }