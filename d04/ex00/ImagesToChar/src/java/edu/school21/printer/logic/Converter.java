package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Converter {

    public Converter (File input, char white, char black) throws IOException {
        BufferedImage image = ImageIO.read(input);
        int width = image.getWidth();
        int height = image.getHeight();
        char[][] pic = new char[height][width];
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (image.getRGB(i, j) == Color.WHITE.getRGB())
                    pic[i][j] = white;
                if (image.getRGB(i, j) == Color.BLACK.getRGB())
                    pic[i][j] = black;
                System.out.print(pic[i][j]);
            }
            System.out.println();
        }
    }
}
