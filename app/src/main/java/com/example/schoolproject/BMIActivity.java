package com.example.schoolproject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class BMIActivity extends AppCompatActivity {

    private AppCompatEditText ediTextHeight, ediTextWeight;
    private AppCompatButton buttonCalculate;
    private AppCompatTextView textViewResult, textViewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ediTextHeight = findViewById(R.id.edittext_height);
        ediTextWeight = findViewById(R.id.edittext_weight);
        buttonCalculate = findViewById(R.id.button_calculate_bmi);
        textViewResult = findViewById(R.id.textview_result);
        textViewNote = findViewById(R.id.textview_note);

        buttonCalculate.setOnClickListener(view -> {
            if (ediTextWeight.length() == 0 || ediTextHeight.length() == 0) {
                Toast.makeText(BMIActivity.this, "Populate Weight and Height to Calculate BMI", Toast.LENGTH_SHORT).show();
            } else {
                double heightInCms = Double.parseDouble(ediTextHeight.getText().toString()) /100;
                double weightInKgs = Double.parseDouble(ediTextWeight.getText().toString());
                double result = weightInKgs / (heightInCms * heightInCms);
                textViewResult.setText(String.format("%.2f", result));
                fillNote(result);
            }

        });
    }

    private void fillNote(double result) {
        if (result < 18.5) {
            textViewNote.setText("You are underweight, please think about your treatment....");
        } else if (result > 18.5 && result < 24.5) {
            textViewNote.setText("You are normal, keep going♥");
        } else if (result > 25 && result < 29.9) {
            textViewNote.setText("You are overweight, it is better to start exercising!");
        } else {
            textViewNote.setText("You are very overweight, you need to see a doctor or start a diet.");
        }
    }

}