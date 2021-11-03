package com.hfad.einmaleins;

import java.util.Random;

public class Exam {
    Random rand = new Random();
    private int numberOne = 0;
    private int numberTwo = 0;
    private int result = 0;
    private String task = "";

    public void setTask(String oldTask, int oldFirstNumber, int oldSecondNumber, int oldResult){
        numberOne = oldFirstNumber;
        numberTwo = oldSecondNumber;
        result = oldResult;
        task = oldTask;
    }

    public void setNewTask(String arithmeticType) {
        numberOne = getNewNumber(numberOne);
        numberTwo = getNewNumber(numberTwo);
        buildTask(arithmeticType, numberOne, numberTwo);
    }

    public void setNewTask(String arithmeticType, String testNumber) {
        if(testNumber.matches("Alle")) {
            numberOne = getNewNumber(numberOne);
        } else {
            numberOne = Integer.parseInt(testNumber);
        }
        numberTwo = getNewNumber(numberTwo);
        buildTask(arithmeticType, numberOne, numberTwo);
    }

    private int getNewNumber(int oldNumber){
        int newNumber = rand.nextInt(10) +1;
        while (oldNumber == newNumber){
            newNumber = rand.nextInt(10) +1;
        }
        return newNumber;
    }

    private void buildTask(String arithmeticType, int firstNumber, int secondNumber){
        switch (arithmeticType){
            case "+":
                result = firstNumber + secondNumber;
                task = firstNumber + " + " + secondNumber;
                break;
            case "x":
                result = firstNumber * secondNumber;
                task = firstNumber + " x " + secondNumber;
                break;
            case "-":
                if(firstNumber >= secondNumber){
                    result = firstNumber - secondNumber;
                    task = firstNumber + " - " + secondNumber;
                } else {
                    result = secondNumber - firstNumber;
                    task = secondNumber + " - " + firstNumber;
                }
                break;
            case ":":
                int newNumber = firstNumber * secondNumber;
                result = secondNumber;
                task = newNumber + ":" + firstNumber;
                break;
        }
    }

    public Boolean checkAnswer(String answer) {
        if(answer.matches("") || Integer.parseInt(answer) != result) {
            return false;
        } else {
            return true;
        }
    }

    public String getTask() {
        return task;
    }

    public int getNumberOne(){
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public int getResult() {
        return result;
    }
}
