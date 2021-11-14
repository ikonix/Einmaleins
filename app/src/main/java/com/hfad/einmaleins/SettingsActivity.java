package com.hfad.einmaleins;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    private int mode = 0;
    private int[] numbers = new int[10];
    private boolean addition = false;
    private boolean subtraction = false;
    private boolean multiplication = true;
    private boolean division = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean isAddition() {
        return addition;
    }

    public void setAddition(boolean addition) {
        this.addition = addition;
    }

    public boolean isSubtraction() {
        return subtraction;
    }

    public void setSubtraction(boolean subtraction) {
        this.subtraction = subtraction;
    }

    public boolean isMultiplication() {
        return multiplication;
    }

    public void setMultiplication(boolean multiplication) {
        this.multiplication = multiplication;
    }

    public boolean isDivision() {
        return division;
    }

    public void setDivision(boolean division) {
        this.division = division;
    }
}