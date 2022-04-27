package com.aetherwars.exception;

public class InvalidBoardException extends Exception{
    public String id;
    public String type;

    public InvalidBoardException(String id, String type){
        this.id = id;
        this.type = type;
    }

    public String toString(){
        return (this.type == "char") ? "Board position " + this.id + " is occupied" : (this.type == "spell") ? "Board position " + this.id + " is empty" : "Board position " + this.id + " is invalid";
    }
}
