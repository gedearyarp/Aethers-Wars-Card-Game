package com.aetherwars.exception;

public class InvalidIDException extends Exception {
    public Integer id;

    public InvalidIDException(Integer id) {
        this.id = id;
    }

    public String toString() {
        return  id + " is not a valid ID";
    }
}
