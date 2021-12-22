package com.hastmohamadi.bmiTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton buttonReady, buttonDissmiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonReady = findViewById(R.id.button_ready);
        buttonDissmiss = findViewById(R.id.button_dismiss);

        buttonReady.setOnClickListener(this);
        buttonDissmiss.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_dismiss:
                finish();
                break;
            case R.id.button_ready:
                Intent bmiIntent= new Intent(MainActivity.this, BMIActivity.class);
                startActivity(bmiIntent);
                break;
            default:
                Toast.makeText(MainActivity.this, "NO OPTIONS!", Toast.LENGTH_SHORT).show();
        }
    }
}