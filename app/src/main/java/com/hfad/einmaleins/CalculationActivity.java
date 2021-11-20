package com.hfad.einmaleins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculationActivity extends AppCompatActivity {
    public static final String SETTINGS = "settings";
    public static final String ARITHMETIC_TYPE = "arithmetic type";
    public static final String RIGHT_ANSWER = "Richtig!";
    public static final String WRONG_ANSWER = "Leider Falsch.";

    private final Exam exam = new Exam();
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String arithmeticType = intent.getStringExtra(ARITHMETIC_TYPE);
        settings = (Settings) intent.getSerializableExtra(SETTINGS);

        Spinner arithmeticTypeSpinner = findViewById(R.id.arithmeticSpinner);
        arithmeticTypeSpinner.setSelection(convertArithmeticType(arithmeticType));

        TextView taskTextView = findViewById(R.id.taskTextView);

        if(savedInstanceState != null){
            exam.setTask(savedInstanceState.getString("task"),
                    savedInstanceState.getInt("numberOne"),
                    savedInstanceState.getInt("numberTwo"),
                    savedInstanceState.getInt("result"));
        } else {
            exam.setNewTask(arithmeticType);
        }

        taskTextView.setText(exam.getTask());
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("task", exam.getTask());
        savedInstanceState.putInt("numberOne", exam.getNumberOne());
        savedInstanceState.putInt("numberTwo", exam.getNumberTwo());
        savedInstanceState.putInt("result", exam.getResult());
    }

    public void onClickNewTaskButton(View view) {
        EditText editText = findViewById(R.id.textField);
        editText.setText("");

        TextView taskTextView = findViewById(R.id.taskTextView);
        exam.setNewTask(getArithmeticTypeSpinner(), getSpinnerNumber());
        taskTextView.setText(exam.getTask());
    }

    public void onClickCheckButton(View view) {
        EditText editText = findViewById(R.id.textField);
        TextView taskTextView = findViewById(R.id.taskTextView);
        Boolean result = exam.checkAnswer(editText.getText().toString());

        Toast answerToast;
        if(result) {
            exam.setNewTask(getArithmeticTypeSpinner(), getSpinnerNumber());
            taskTextView.setText(exam.getTask());
            answerToast = Toast.makeText(this, RIGHT_ANSWER, Toast.LENGTH_SHORT);
        } else {
            answerToast = Toast.makeText(this, WRONG_ANSWER, Toast.LENGTH_SHORT);
        }
        answerToast.show();
        editText.setText("");
    }

    public String getSpinnerNumber(){
        Spinner testNumberSpinner = findViewById(R.id.numberSpinner);
        return String.valueOf(testNumberSpinner.getSelectedItem());
    }

    public String getArithmeticTypeSpinner(){
        Spinner arithmeticTypeSpinner = findViewById(R.id.arithmeticSpinner);
        return String.valueOf(arithmeticTypeSpinner.getSelectedItem());
    }

    private int convertArithmeticType(String arithmeticType){
        switch (arithmeticType){
            case "+":
                return 0;
            case "x":
                return 1;
            case "-":
                return 2;
            case ":":
                return 3;
        }
        return -1;
    }
}