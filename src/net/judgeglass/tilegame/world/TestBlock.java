package net.judgeglass.tilegame.world;

import net.judgeglass.jgameengine.core.io.Log;
import net.judgeglass.tilegame.Game;
import net.judgeglass.jgameengine.core.entity.GameObject;
import net.judgeglass.jgameengine.core.input.Mouse;
import net.judgeglass.jgameengine.gfx.Screen;

public class TestBlock extends GameObject{

    private WorldGen worldGen;

    private int counter = 0;

    public TestBlock(int x, int y){
        super(x, y);
        spriteSheet = Game.spriteSheet;

        worldGen = new WorldGen();
    }


    @Override
    public void render(Screen s){
        if(worldGen != null)
            worldGen.render(s);
    }

    @Override
    public void tick(){
        worldGen.tick();
        x = Mouse.getX();
        y = Mouse.getY();
        counter++;
    }
}
