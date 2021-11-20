package com.hfad.einmaleins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class StartActivity extends AppCompatActivity {

    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        settings = new Settings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
        intent.putExtra(CalculationActivity.SETTINGS, settings);
        startActivity(intent);
    }
}