package net.judgeglass.tilegame.ui;

import net.judgeglass.jgameengine.core.io.Log;
import net.judgeglass.tilegame.Game;
import net.judgeglass.jgameengine.core.entity.GameObject;
import net.judgeglass.jgameengine.gfx.Font;
import net.judgeglass.jgameengine.gfx.Screen;
import net.judgeglass.tilegame.world.WorldGen;

public class HUD extends GameObject {

    public HUD() {
        super(0, 0);
        spriteSheet = Game.spriteSheet;

    }

    @Override
    public void render(Screen s) {
        Font.draw(5, 5, "TG v0.0.1 (Hunter Wilcox) - FPS: " + s.getRenderer().getFps(),2, 0x000000, s, spriteSheet);
        Font.draw(2, 2, "TG v0.0.1 (Hunter Wilcox) - FPS: " + s.getRenderer().getFps(),2, 0xFFFFFF, s, spriteSheet);
    }

    @Override
    public void tick() {

    }
}
