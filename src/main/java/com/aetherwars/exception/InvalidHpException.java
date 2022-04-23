package com.aetherwars.exception;

public class InvalidHpException extends Exception {
    public Integer hp;

    public InvalidHpException(Integer hp) {
        this.hp = hp;
    }

    public String toString() {
        return  "Invalid mana exception: " + hp + ", must be more than or equal 0";
    }
}
