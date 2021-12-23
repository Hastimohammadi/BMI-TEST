package com.hastmohamadi.bmiTest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.bmiTest.R;

import java.util.Objects;

public class BMIActivity extends AppCompatActivity {

    private AppCompatEditText ediTextHeight, ediTextWeight;
    private AppCompatTextView textViewResult, textViewNote;
    private AppCompatImageView imageResult;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ediTextHeight = findViewById(R.id.edittext_height);
        ediTextWeight = findViewById(R.id.edittext_weight);
        AppCompatButton buttonCalculate = findViewById(R.id.button_calculate_bmi);
        textViewResult = findViewById(R.id.textview_result);
        textViewNote = findViewById(R.id.textview_note);
        imageResult = findViewById(R.id.image_result);

        buttonCalculate.setOnClickListener(view -> {
            if (ediTextWeight.length() == 0 || ediTextHeight.length() == 0) {
                Toast.makeText(BMIActivity.this, getString(R.string.populate), Toast.LENGTH_SHORT).show();
            } else {
                double heightInCms = Double.parseDouble(Objects.requireNonNull(ediTextHeight.getText()).toString()) / 100;
                double weightInKgs = Double.parseDouble(Objects.requireNonNull(ediTextWeight.getText()).toString());
                double result = weightInKgs / (heightInCms * heightInCms);
                textViewResult.setText(String.format("%.2f", result));
                fillNote(result);
            }

        });
    }

    private void fillNote(double result) {
        if (result < 18.5) {
            textViewNote.setText(R.string.underweight_note);
            imageResult.setImageResource(R.drawable.underweight);
        } else if (result > 18.5 && result < 24.5) {
            textViewNote.setText(R.string.normal_note);
            imageResult.setImageResource(R.drawable.normal_note);
        } else if (result > 25 && result < 29.9) {
            textViewNote.setText(R.string.overweight_note);
            imageResult.setImageResource(R.drawable.overweight_note);
        } else {
            textViewNote.setText(R.string.fat_note);
            imageResult.setImageResource(R.drawable.fat_note);

        }
    }

}