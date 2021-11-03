package com.hfad.einmaleins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String ARITHMETIC_TYPE = "arithmetic type";
    public static final String RIGHT_ANSWER = "Richtig!";
    public static final String WRONG_ANSWER = "Leider Falsch.";

    private final Exam exam = new Exam();
    private Toast answerToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String arithmeticType = intent.getStringExtra(ARITHMETIC_TYPE);

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
    protected void onSaveInstanceState(Bundle savedInstanceState) {
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
        String testNumber = String.valueOf(testNumberSpinner.getSelectedItem());
        return testNumber;
    }

    public String getArithmeticTypeSpinner(){
        Spinner arithmeticTypeSpinner = findViewById(R.id.arithmeticSpinner);
        String arithmeticType = String.valueOf(arithmeticTypeSpinner.getSelectedItem());
        return arithmeticType;
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