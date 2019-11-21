package net.judgeglass.tilegame.world;

import net.judgeglass.jgameengine.core.io.Log;
import net.judgeglass.tilegame.Game;
import net.judgeglass.jgameengine.gfx.AnimatedTile;
import net.judgeglass.jgameengine.gfx.PixelDrawer;
import net.judgeglass.jgameengine.gfx.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGen {
    /* Animated Tiles */

    private int[] waterSprites = {0, 1, 2};
    private AnimatedTile animatedWaterTile = new AnimatedTile(0, 0, Game.spriteSheet, waterSprites, 28, 2);

    private int[] lavaSprites = {33, 34, 35};
    private AnimatedTile animatedLavaTile = new AnimatedTile(0, 0, Game.spriteSheet, lavaSprites, 28, 2);

    /*----------------*/


    private List<WorldData> worldData;
    private Random rand;

    public static int xOff;
    public static int yOff;

    public WorldGen() {
        worldData = new ArrayList<>();
        rand = new Random();
        make();
    }

    public void setCameraPos(int x, int y){
        xOff = x;
        yOff = y;
    }

    private void make(){
        for(int x = -64; x < 64; x++){
            for(int y = -64; y < 64; y++){
                int randNum = rand.nextInt(6);

                if(rand.nextInt(1000)  == 10){
                    worldData.add(new WorldData(x * 16, y * 16, 3));
                    continue;
                }

                if(randNum <= 3){
                    randNum = 4;
                }

                worldData.add(new WorldData(x * 16, y * 16, randNum));
            }
        }
    }

    public void render(Screen s) {
        for(WorldData tile: worldData){
            switch (tile.sprite){
                case 3:
                case 2:
                case 1:
                case 0:
                    animatedWaterTile.render(s, tile.x + xOff, tile.y + yOff);
                    continue;
            }
            PixelDrawer.drawSprite(tile.x + xOff, tile.y + yOff, Game.spriteSheet, s, tile.sprite,2);
        }
    }

    public void tick(){
        animatedWaterTile.tick();
    }

    public List<WorldData> getWorldData() {
        return worldData;
    }

    private class WorldData {
        public int x;
        public int y;
        public int sprite;

        public WorldData(int x, int y, int sprite) {
            this.x = x;
            this.y = y;
            this.sprite = sprite;
        }
    }
}
