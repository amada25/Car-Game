package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class Identify_the_manufacturer extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_manufacturer);
        String[] carNames = {"Audi","Bentley","BMW","Bugatti","Chevrolet","Citroen","Dacia","Ferrari","Fiat","Ford","FordMustang","Honda","Hyundai",
                "Jeep","KiaMotors","Lamborghini","LandRover","Mercedes","Mitsubishi","Nissan","Opel","Peugeot","Porsche","Renault","Skoda",
                "Suzuki","Tesla","Toyota","Volkswagen","Volvo"};
        final String carName;
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
        final ImageView carImage;
        Button verify, tryAgain;
        TextView result, result1;

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_identifyTheManufacturer_carNames);
        mySpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Identify_the_manufacturer.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.CarNames));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        carImage = findViewById(R.id.iv_identifyTheManufacturer_carImage);
        result= findViewById(R.id.tv_identifyTheManufacturer_scoreName);
        result1=findViewById(R.id.tv_identifyTheManufacturer_score);
        verify = findViewById(R.id.b_identifyTheManufacturer_verify);
        tryAgain = findViewById(R.id.b_identifyTheCarManufacturer_tryAgain);
        tryAgain.setVisibility(View.INVISIBLE);

        Random random = new Random();
        int myRandomNumber = random.nextInt(30); //random number between 1-30
        carImage.setImageResource(randomCar[myRandomNumber]);//the random number is displayed
        result.setVisibility(View.INVISIBLE);
        carName = carNames[myRandomNumber];
        SpannableStringBuilder correct = new SpannableStringBuilder();
        SpannableStringBuilder wrong = new SpannableStringBuilder();



        String correct1="Correct!"; // this text have to be green
        SpannableString greenSpannable= new SpannableString(correct1);
        greenSpannable.setSpan(new ForegroundColorSpan(Color.GREEN), 0, correct1.length(), 0);
        correct.append(greenSpannable);

        String wrong1="Wrong"; // this text have to be red
        SpannableString redSpannable= new SpannableString(wrong1);
        redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, wrong1.length(), 0);
        wrong.append(redSpannable);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chosenCarName = String.valueOf(mySpinner.getSelectedItem());
                SpannableString str = new SpannableString(chosenCarName);
               str.setSpan(new ForegroundColorSpan(Color.BLACK),0,chosenCarName.length(),0);

                result.setText(carName,TextView.BufferType.SPANNABLE);

                result.setVisibility(View.VISIBLE);
                verify.setVisibility(View.INVISIBLE);
                mySpinner.setVisibility(View.INVISIBLE);
                tryAgain.setVisibility(View.VISIBLE);

                if(chosenCarName.equals(carName)){
                    result.setText("Correct!");
                    result.setTextColor(Color.GREEN);
                }else{
                    result.setText("Wrong!");
                    result.setTextColor(Color.RED);
                    result1.setText(carName);
                }


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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String selected= String.valueOf(parent.getItemAtPosition(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}