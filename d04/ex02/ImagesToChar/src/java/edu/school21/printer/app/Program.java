package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.io.IOException;
import edu.school21.printer.logic.*;

@Parameters(separators = "=")
public class Program {
    public static final String path = "/resources/image.bmp";
    @Parameter(names={"--white"})
    static String WHITE;
    @Parameter(names={"--black"})
    static String BLACK;


    public static void main(String[] args) {
        Program program = new Program();
        JCommander.newBuilder().addObject(program).build().parse(args);
        if (args.length != 2)
            printError("Invalid number of arguments");
        else {
            try {
                Converter converter = new Converter(path, WHITE, BLACK);
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
