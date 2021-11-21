package com.hfad.einmaleins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    public static final String SETTINGS = "settings";
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        settings = (Settings) intent.getSerializableExtra(SETTINGS);

        if(savedInstanceState != null) {
            settings.setMode(savedInstanceState.getInt("mode"));
            settings.setNumbers(savedInstanceState.getBooleanArray("numbers"));
            settings.setAddition(savedInstanceState.getBoolean("addition"));
            settings.setSubtraction(savedInstanceState.getBoolean("subtraction"));
            settings.setMultiplication(savedInstanceState.getBoolean("multiplication"));
            settings.setDivision(savedInstanceState.getBoolean("division"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("mode", settings.getMode());
        savedInstanceState.putBoolean("addition", settings.isAddition());
        savedInstanceState.putBoolean("subtraction", settings.isSubtraction());
        savedInstanceState.putBoolean("multiplication", settings.isMultiplication());
        savedInstanceState.putBoolean("division", settings.isDivision());
        savedInstanceState.putBooleanArray("numbers", settings.getNumbers());
    }

    public void onOperationCheckboxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.additionCheckBox:
                settings.setAddition(isChecked);
                break;
            case R.id.subtractionCheckBox:
                settings.setSubtraction(isChecked);
                break;
            case R.id.multiplicationCheckBox:
                settings.setMultiplication(isChecked);
                break;
            case R.id.divisionCheckBox:
                settings.setDivision(isChecked);
                break;
        }
    }

    public void onNumberCheckBoxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.oneCheckBox:
                settings.setSingleNumber(isChecked, 0);
                break;
            case R.id.twoCheckBox:
                settings.setSingleNumber(isChecked, 1);
                break;
            case R.id.threeCheckBox:
                settings.setSingleNumber(isChecked, 2);
                break;
            case R.id.fourCheckBox:
                settings.setSingleNumber(isChecked, 3);
                break;
            case R.id.fiveCheckBox:
                settings.setSingleNumber(isChecked, 4);
                break;
            case R.id.sixCheckBox:
                settings.setSingleNumber(isChecked, 5);
                break;
            case R.id.sevenCheckBox:
                settings.setSingleNumber(isChecked, 6);
                break;
            case R.id.eightCheckBox:
                settings.setSingleNumber(isChecked, 7);
                break;
            case R.id.nineCheckBox:
                settings.setSingleNumber(isChecked, 8);
                break;
            case R.id.tenCheckBox:
                settings.setSingleNumber(isChecked, 9);
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        RadioGroup modeRadioGroup = findViewById(R.id.radioGroup);
        settings.setMode(modeRadioGroup.getCheckedRadioButtonId());
    }
}