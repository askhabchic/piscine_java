package edu.school21.printer.app;

import java.io.File;
import java.io.IOException;
import edu.school21.printer.logic.*;

public class Program {
    public static String path;
    public static char white;
    public static char black;

    public static void main(String[] args) {
        if (args.length != 3)
            printError("Invalid number of arguments");
        else if (args[0].length() > 1 || args[1].length() > 1) {
            printError("Invalid symbols");
        } else {
            white = args[0].charAt(0);
            black = args[1].charAt(0);
            path = args[2];
            File file = new File(path);
            try {
                if (file.exists() && file.isFile()) {
                    Converter converter = new Converter(file, white, black);
                } else {
                    throw new IOException("File does not exist");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printError(String err) {
        System.err.println(err);
        System.exit(-1);
    }
}
