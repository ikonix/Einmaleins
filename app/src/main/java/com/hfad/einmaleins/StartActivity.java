package com.hfad.einmaleins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
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

    public void startMainActivity(String arithmeticType){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.ARITHMETIC_TYPE, arithmeticType);
        startActivity(intent);
    }
}