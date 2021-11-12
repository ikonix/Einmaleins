package com.hfad.einmaleins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClickAddition(View view){
        startMainActivity("+");
    }

    public void onClickMultiplication(View view){
        startMainActivity("x");
    }

    public void onClickSubtraction(View view){
        startMainActivity("-");
    }

    public void onClickDivision(View view){
        startMainActivity(":");
    }

    public void startMainActivity(String arithmeticType) {
        Intent intent = new Intent(this, CalculationActivity.class);
        intent.putExtra(CalculationActivity.ARITHMETIC_TYPE, arithmeticType);
        startActivity(intent);
    }
}