package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.IOException;
import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

public class Converter {

    public Converter (String input, String white, String black) throws IOException {
        Attribute WHITE = colors(white);
        Attribute BLACK = colors(black);
        BufferedImage image = ImageIO.read(Converter.class.getResource(input));
        int width = image.getWidth();
        int height = image.getHeight();
        char[][] pic = new char[height][width];
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (image.getRGB(i, j) == Color.WHITE.getRGB())
                    System.out.print(Ansi.colorize(" ", WHITE));
                if (image.getRGB(i, j) == Color.BLACK.getRGB())
                    System.out.print(Ansi.colorize(" ", BLACK));
            }
            System.out.println();
        }
    }

    public Attribute colors(String color) throws InvalidColorException {
        switch (color) {
            case "BLACK":
                return Attribute.BLACK_BACK();
            case "WHITE":
                return Attribute.WHITE_BACK();
            case "GREEN":
                return Attribute.GREEN_BACK();
            case "YELLOW":
                return Attribute.YELLOW_BACK();
            case "BLUE":
                return Attribute.BLUE_BACK();
            case "RED":
                return Attribute.RED_BACK();
            default:
                throw new InvalidColorException();
        }
    }
}
