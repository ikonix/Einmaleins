package com.hfad.einmaleins;

import java.io.Serializable;

public class Settings implements Serializable {

    private int mode;
    private boolean[] numbers;
    private boolean addition;
    private boolean subtraction;
    private boolean multiplication;
    private boolean division;

    public Settings() {
        this.mode = 0;
        this.numbers = new boolean[]{true, true, true, true, true,
                true, true, true, true, true};
        this.addition = false;
        this.subtraction = false;
        this.multiplication = true;
        this.division = false;
    }

    public Settings(int mode, boolean[] numbers, boolean addition, boolean subtraction, boolean multiplication, boolean division) {
        this.mode = mode;
        this.numbers = numbers;
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
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

    public boolean isDivision() {
        return division;
    }

    public void setDivision(boolean division) {
        this.division = division;
    }
}
