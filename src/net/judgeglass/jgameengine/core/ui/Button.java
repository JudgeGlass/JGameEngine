package net.judgeglass.jgameengine.core.ui;

import net.judgeglass.jgameengine.gfx.Screen;


import static net.judgeglass.jgameengine.gfx.PixelDrawer.*;

public class Button{

    private int x;
    private int y;
    private int width;
    private int height;
    private int color;
    private int borderColor;
    private String text;

    public Button(int x, int y, int width, int height, String text, int color, int borderColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.borderColor= borderColor;
        this.text = text;
    }

    public void render(Screen s) {
        drawRect(x, y, width, height, borderColor, s);
    }

    public void tick() {

    }
}
