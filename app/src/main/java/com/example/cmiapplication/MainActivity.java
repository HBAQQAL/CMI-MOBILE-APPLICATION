package com.example.cmiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    EditText height;
    TextView result;
    ImageView image;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weightInput);
        height = findViewById(R.id.sizeInput);
        result = findViewById(R.id.resultText);
        image = findViewById(R.id.resultImage);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            String weightString = weight.getText().toString();
            String heightString = height.getText().toString();

            float weightValue =  Float.parseFloat(weightString);
            float heightValue =  Float.parseFloat(heightString) / 100; // convert to meters

            float imc = weightValue / (heightValue * heightValue);

            result.setText(imc + "");

            if (imc < 18.5) {
                image.setImageResource(R.drawable.maigre);
            } else if (imc < 24.9) {
                image.setImageResource(R.drawable.normal);
            } else if (imc < 29.9) {
                image.setImageResource(R.drawable.surpoids);
            } else if (imc < 34.9) {
                image.setImageResource(R.drawable.obese);
            } else if (imc < 39.9) {
                image.setImageResource(R.drawable.t_obese);
            } else {
                image.setImageResource(R.drawable.t_obese);
            }
        });
    }
}