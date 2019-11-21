package net.judgeglass.jgameengine.core.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage image;
    private String filename;
    private int width;
    private int height;
    private int pw;
    private int ph;
    public int pixels[];

    public SpriteSheet(String file, int pw, int ph){
        this.pw = pw;
        this.ph = ph;
        try {
            filename = file;
            image = ImageIO.read(new FileInputStream(file));
        } catch (IOException e) {
            Log.error("Could not fine spritesheet: " + file);
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();

        pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        Log.info("SpriteSheet Size: " + (width * height));
        image = null;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getPixelWidth(){
        return pw;
    }

    public int getPixelHeight(){
        return ph;
    }

    public String getFilename(){
        return filename;
    }
}
