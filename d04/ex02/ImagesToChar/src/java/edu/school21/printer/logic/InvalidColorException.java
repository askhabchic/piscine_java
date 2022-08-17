package edu.school21.printer.logic;

public class InvalidColorException extends RuntimeException {
    public InvalidColorException() {
        super("Invalid color");
    }
}
