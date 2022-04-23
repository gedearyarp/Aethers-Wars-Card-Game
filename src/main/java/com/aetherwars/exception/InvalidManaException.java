package com.aetherwars.exception;

public class InvalidManaException extends Exception {
    public int mana;

    public InvalidManaException(int mana) {
        this.mana = mana;
    }

    public String toString() {
        return  "Invalid mana exception: " + mana + ", must be between 0 and 10";
    }
}