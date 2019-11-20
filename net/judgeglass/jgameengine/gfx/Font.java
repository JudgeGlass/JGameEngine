package net.judgeglass.jgameengine.gfx;

import net.judgeglass.jgameengine.core.io.SpriteSheet;

public class Font {
    private static String chars = "" + //
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ      " + //
            "0123456789.,!?'\"-+=/\\%()<>:;     " + //
            "";

    public static void draw(int x, int y, String message, int scale, int color, Screen s, SpriteSheet spriteSheet){
        if(spriteSheet == null) return;
        message = message.toUpperCase();
        for(int i = 0; i < message.length(); i++){
            int charIndex = chars.indexOf(message.charAt(i));
            if(charIndex >= 0) PixelDrawer.drawFont(x + i * spriteSheet.getPixelWidth() * scale, y, spriteSheet, s, charIndex + 30 * 32, scale, color);
        }
    }
}
