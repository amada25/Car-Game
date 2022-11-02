package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Name_the_car extends AppCompatActivity {
    ImageView carImage;
    Button verify, tryAgain;
    TextView carName, result;
    EditText input;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_the_car);
        String[] carNames = {"Audi","Bentley","BMW","Bugatti","Chevrolet","Citroen","Dacia","Ferrari","Fiat","Ford","FordMustang","Honda","Hyundai",
                "Jeep","KiaMotors","Lamborghini","LandRover","Mercedes","Mitsubishi","Nissan","Opel","Peugeot","Porsche","Renault","Skoda",
                "Suzuki","Tesla","Toyota","Volkswagen","Volvo"};
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
                tryAgain=findViewById(R.id.b_nameTheCar_tryAgain);
                tryAgain.setVisibility(View.INVISIBLE);
                verify=findViewById(R.id.b_nameTheCar_verify);
                carImage=findViewById(R.id.iv_nameTheCar_carImage);
                carImage=findViewById(R.id.iv_nameTheCar_carImage);
                input=findViewById(R.id.et_nameTheCar_insertTheCarName);
                result=findViewById(R.id.tv_nameTheCar_result);
                result.setVisibility(View.INVISIBLE);
                carName=findViewById(R.id.tv_nameTheCar_carName);
                carName.setVisibility(View.INVISIBLE);

                Random random = new Random();
                int myRandomNumber = random.nextInt(30);
                carImage.setImageResource(randomCar[myRandomNumber]);
                name = carNames[myRandomNumber];

                verify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name1;
                        name1= String.valueOf(input.getText());
                        result.setVisibility(View.VISIBLE);

                        tryAgain.setVisibility(View.VISIBLE);
                        if(name1.toLowerCase().equals(name.toLowerCase())){
                            result.setText("Correct!");
                            result.setTextColor(Color.GREEN);
                        }
                        else{
                            result.setText("Wrong!");
                            result.setTextColor(Color.RED);
                            carName.setVisibility(View.VISIBLE);
                            carName.setText(name);
                        }
                        input.setVisibility(View.INVISIBLE);
                        verify.setVisibility(View.INVISIBLE);
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