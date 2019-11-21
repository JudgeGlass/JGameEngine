package net.judgeglass.tilegame.player;

import net.judgeglass.jgameengine.core.entity.GameObject;
import net.judgeglass.jgameengine.gfx.PixelDrawer;
import net.judgeglass.jgameengine.gfx.Screen;

public class Player extends GameObject {
    public Player(int x, int y) {
        super(x, y);

    }

    @Override
    public void render(Screen s) {
        drawPlayer(s);
    }

    @Override
    public void tick() {

    }

    private void drawPlayer(Screen s){
        PixelDrawer.drawRect(s.getWidth() / 2, s.getHeight() / 2, 16, 48, 0xFF0000, s);
    }
}
