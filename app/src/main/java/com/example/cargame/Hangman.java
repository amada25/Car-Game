package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;
import java.util.Random;

public class Hangman extends AppCompatActivity {
    ImageView carImage;
    Button verify, tryAgain;
    TextView carName,result;
    String name1;
    TextInputLayout inputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        carImage=findViewById(R.id.iv_hangman_carImage);
        verify=findViewById(R.id.b_hangman_verify);
        tryAgain=findViewById(R.id.b_hangman_tryAgain);
        tryAgain.setVisibility(View.INVISIBLE);
        carName=findViewById(R.id.tv_hangman_carName);
        inputLayout=findViewById(R.id.inputLayout);
        result=findViewById(R.id.tv_hangman_result);
        result.setVisibility(View.INVISIBLE);

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
        TextInputEditText input = (TextInputEditText) findViewById(R.id.input);

        Random random = new Random();
        int myRandomNumber = random.nextInt(30);
        carImage.setImageResource(randomCar[myRandomNumber]);

        StringBuilder dashes = new StringBuilder(100);
        String carPicked=carNames[myRandomNumber]; //taking the name of the car chosen
        for(int i=1;i<=carPicked.length();i++) {
            dashes.append("*"); //it contains as much dashes as characters in the name
        }
        carName.setText(dashes);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //when a char is inserted
                String character= String.valueOf(input.getText());
                StringBuilder name2 = new StringBuilder(100);
                StringBuilder finalName = new StringBuilder(100);
                Character star='*';
                name1= String.valueOf(carName.getText());

                for(int i=0;i<=carPicked.length()-1;i++) {
                    if(character.toLowerCase().equals(String.valueOf(carPicked.charAt(i)).toLowerCase()) ) //insensitive cases
                    { name2.append(character);} //the inserted char and dashes appears
                    else
                    {name2.append("*");
                        //newString.append(name.charAt(i));}
                    }

                }
                for(int i=0;i<=name2.length()-1;i++){
                    if(star.equals(name1.charAt(i))){
                        finalName.append(name2.charAt(i));
                    }
                    else{
                        finalName.append(name1.charAt(i));
                    }
                }
                input.getText().clear();
                input.setHint("Letter");
                input.clearFocus();
                if(String.valueOf(finalName).toLowerCase().equals(carPicked.toLowerCase()))
                {//carName.setText("You won!");
                  carName.setText(String.valueOf(finalName).toUpperCase());
                  input.setVisibility(View.INVISIBLE);
                  verify.setVisibility(View.INVISIBLE);
                  inputLayout.setVisibility(View.INVISIBLE);
                  tryAgain.setVisibility(View.VISIBLE);
                  result.setVisibility(View.VISIBLE);
                  result.setText("You won!");
                  result.setTextColor(Color.GREEN);
                }
                else{
                carName.setText(String.valueOf(finalName).toUpperCase());}
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