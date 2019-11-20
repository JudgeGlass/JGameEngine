package net.judgeglass.jgameengine.gfx;

import net.judgeglass.jgameengine.core.io.SpriteSheet;

public class AnimatedTile{

    private int[] sprites;
    private int delayMili;
    private int scale;
    private int x;
    private int y;
    private SpriteSheet spriteSheet;

    private int counter = 0;
    private int index = 0;

    public AnimatedTile(int x, int y, SpriteSheet spriteSheet, int[] sprites, int delayMili, int scale) {
        this.x = x;
        this.y = y;
        this.spriteSheet = spriteSheet;
        this.sprites = sprites;
        this.delayMili = delayMili;
        this.scale = scale;
    }

    public void render(Screen s, int xx, int yy) {
        PixelDrawer.drawSprite(xx, yy, this.spriteSheet, s, sprites[index], scale);
    }

    public void tick() {
        if(counter % delayMili == 0){
            if(index+1 < sprites.length){
                index++;
            }else{
                index = 0;
            }
        }
        counter++;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
