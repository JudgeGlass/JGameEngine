package net.judgeglass.jgameengine.gfx;

import net.judgeglass.jgameengine.core.entity.GameObject;
import net.judgeglass.jgameengine.core.io.SpriteSheet;

public class PixelDrawer {
    public static void drawRect(int x, int y, int w, int h, int col, Screen s){
        for(int xx = x; xx < x + w; xx++){
            for(int yy = y; yy < y + h; yy++){
                if(yy < s.getHeight())
                    s.pixels[xx + yy * s.getWidth()] = col;
            }
        }
    }

    public static void drawRect(int x, int y, int w, int h, int col, int lw, Screen s){
        drawHorizontalLine(x, y, y + h, lw, col, s);
        drawHorizontalLine(x + w - lw, y, y + h, lw, col, s);
        drawVerticalLine(y, x, x + w, lw, col, s);
        drawVerticalLine(y + h, x, x + w, lw, col, s);
    }

    public static void drawLine(int x1, int y1, int x2, int y2, int col, Screen s){
        int dx = x2 - x1;
        int dy = y2 - y1;
        int yi = 1;
        if(dy < 0){
            yi = -1;
            dy = -dy;
        }
        int d = 2 * dy - dx;
        int y = y1;

        for(int x = x1; x < x2; x++){
            s.getRenderer().drawPixel(x, y, col);
            if(d > 0){
                y += yi;
                d -= 2 * dx;
            }
            d += 2 * dy;
        }
    }

    public static void drawHorizontalLine(int x1, int y1, int y2, int w, int col, Screen s){
        int off = 0;
        if(w == 1){
            off = 0;
        }else if(w % 3 == 0){
            off = w / 2;
        }
        for(int x = x1-off; x < x1 + w; x++) {
            for (int y = y1; y < y2; y++) {
                s.getRenderer().drawPixel(x, y, col);
            }
        }
    }

    public static void drawVerticalLine(int y1, int x1, int x2, int w, int col, Screen s){
        int off = 0;
        if(w == 1){
            off = 0;
        }else if(w % 3 == 0){
            off = w / 2;
        }
        for(int y = y1-off; y < y1 + w; y++) {
            for (int x = x1; x < x2; x++) {
                s.getRenderer().drawPixel(x, y, col);
            }
        }
    }

    public static void drawSprite(GameObject object, SpriteSheet spriteSheet, Screen screen, int c, int z){
        drawSprite(object.getX(), object.getY(), spriteSheet, screen, c, z);
    }

    public static void drawFont(int xx, int yy, SpriteSheet spriteSheet, Screen screen, int c, int z, int color){
        if(spriteSheet == null){
            return;
        }
        int xOffset = c % (spriteSheet.getPixelWidth() * 4);
        int yOffset = c / (spriteSheet.getPixelHeight() * 4);
        int toffs = xOffset * spriteSheet.getPixelWidth() + yOffset * spriteSheet.getPixelHeight() * spriteSheet.getWidth();
        for(int y = 0; y < spriteSheet.getPixelHeight(); y++){
            if (y + yy < 0 || y + yy >= screen.getHeight()) continue;
            for(int x = 0; x < spriteSheet.getPixelWidth(); x++){
                if (x + xx < 0 || x + xx >= screen.getWidth()) continue;
                for(int zx = 0; zx < z; zx++) {
                    for (int zy = 0; zy < z; zy++) {
                        int tx = (x * z) + xx + zx;
                        int ty = (y * z) + yy + zy;
                        if(tx > screen.getWidth() || tx < 0 || ty > screen.getHeight() || ty < 0){
                            continue;
                        }
                        int col = spriteSheet.pixels[(x + y * spriteSheet.getWidth() + toffs)];
                        if(col != 0xff000000){
                            screen.pixels[((x * z) + xx + zx) + ((y * z) + yy + zy) * screen.getWidth()] = color;
                        }
                    }
                }
            }
        }
    }

    public static void drawSprite(int xx, int yy, SpriteSheet spriteSheet, Screen screen, int c, int z){
        if(spriteSheet == null){
            return;
        }
        int xOffset = c % (spriteSheet.getPixelWidth() * 4);
        int yOffset = c / (spriteSheet.getPixelHeight() * 4);
        int toffs = xOffset * spriteSheet.getPixelWidth() + yOffset * spriteSheet.getPixelHeight() * spriteSheet.getWidth();
        for(int y = 0; y < spriteSheet.getPixelHeight(); y++){
            if (y + yy < 0 || y + yy >= screen.getHeight()) continue;
            for(int x = 0; x < spriteSheet.getPixelWidth(); x++){
                if (x + xx < 0 || x + xx >= screen.getWidth()) continue;
                for(int zx = 0; zx < z; zx++) {
                    for (int zy = 0; zy < z; zy++) {
                        int tx = (x * z) + xx + zx;
                        int ty = (y * z) + yy + zy;
                        if(tx > screen.getWidth() || tx < 0 || ty > screen.getHeight() || ty < 0){
                            continue;
                        }
                        int col = spriteSheet.pixels[(x + y * spriteSheet.getWidth() + toffs)];


                        //screen.pixels[((x * z) + xx + zx) + ((y * z) + yy + zy) * screen.getWidth()] = col;
                        screen.getRenderer().drawPixel(((x * z) + xx + zx), ((y * z) + yy + zy), col);
                    }
                }
            }
        }
    }
}
