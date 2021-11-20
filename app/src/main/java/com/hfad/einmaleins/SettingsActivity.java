package com.hfad.einmaleins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    private int mode = 0;
    private boolean[] numbers = {true, true, true, true, true,
                                true, true, true, true, true};
    private boolean addition = false;
    private boolean subtraction = false;
    private boolean multiplication = true;
    private boolean division = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        if(savedInstanceState != null) {
            mode = savedInstanceState.getInt("mode");
            numbers = savedInstanceState.getBooleanArray("numbers");
            addition = savedInstanceState.getBoolean("addition");
            subtraction = savedInstanceState.getBoolean("subtraction");
            multiplication = savedInstanceState.getBoolean("multiplication");
            division = savedInstanceState.getBoolean("division");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("mode", mode);
        savedInstanceState.putBoolean("addition", addition);
        savedInstanceState.putBoolean("subtraction", subtraction);
        savedInstanceState.putBoolean("multiplication", multiplication);
        savedInstanceState.putBoolean("division", division);
        savedInstanceState.putBooleanArray("numbers", numbers);
    }

    public void onOperationCheckboxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.additionCheckBox:
                addition = isChecked;
                break;
            case R.id.subtractionCheckBox:
                subtraction = isChecked;
                break;
            case R.id.multiplicationCheckBox:
                multiplication = isChecked;
                break;
            case R.id.divisionCheckBox:
                division = isChecked;
                break;
        }
    }

    public void onNumberCheckBoxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.oneCheckBox:
                numbers[0] = isChecked;
                break;
            case R.id.twoCheckBox:
                numbers[1] = isChecked;
                break;
            case R.id.threeCheckBox:
                numbers[2] = isChecked;
                break;
            case R.id.fourCheckBox:
                numbers[3] = isChecked;
                break;
            case R.id.fiveCheckBox:
                numbers[4] = isChecked;
                break;
            case R.id.sixCheckBox:
                numbers[5] = isChecked;
                break;
            case R.id.sevenCheckBox:
                numbers[6] = isChecked;
                break;
            case R.id.eightCheckBox:
                numbers[7] = isChecked;
                break;
            case R.id.nineCheckBox:
                numbers[8] = isChecked;
                break;
            case R.id.tenCheckBox:
                numbers[9] = isChecked;
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        RadioGroup modeRadioGroup = findViewById(R.id.radioGroup);
        mode = modeRadioGroup.getCheckedRadioButtonId();
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public boolean[] getNumbers() {
        return numbers;
    }

    public void setNumbers(boolean[] numbers) {
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
}