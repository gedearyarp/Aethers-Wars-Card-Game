package com.aetherwars.exception;

public class IndexOutOfBoundException {
    private String name;

    public IndexOutOfBoundException(String name) {
        this.name = name;
    }

    public String toString() {
        return "Index out of bound at " + name;
    }
}
