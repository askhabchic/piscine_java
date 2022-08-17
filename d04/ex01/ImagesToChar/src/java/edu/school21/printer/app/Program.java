package edu.school21.printer.app;

import java.io.IOException;
import edu.school21.printer.logic.*;

public class Program {
    public static final String path = "/resources/image.bmp";
    public static char white;
    public static char black;

    public static void main(String[] args) {
        if (args.length != 2)
            printError("Invalid number of arguments");
        else if (args[0].length() > 1 || args[1].length() > 1) {
            printError("Invalid symbols");
        } else {
            white = args[0].charAt(0);
            black = args[1].charAt(0);
            try {
                Converter converter = new Converter(path, white, black);
            } catch (IOException e) {
                printError("File does not exist");
                e.printStackTrace();
            }
        }
    }

    public static void printError(String err) {
        System.err.println(err);
        System.exit(-1);
    }
}
