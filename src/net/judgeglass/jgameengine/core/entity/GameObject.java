package net.judgeglass.jgameengine.core.entity;

import net.judgeglass.jgameengine.gfx.Screen;
import net.judgeglass.jgameengine.core.io.SpriteSheet;
import net.judgeglass.jgameengine.core.logic.Collider;

public abstract class GameObject {

    protected int x;
    protected int y;

    protected Collider collider;
    protected SpriteSheet spriteSheet;
    protected String name;

    public GameObject(int x, int y){
        Entity.add(this);
        this.x = x;
        this.y = y;
        collider = null;
    }

    public abstract void render(Screen s);
    public abstract void tick();

    public void setSpriteSheet(SpriteSheet spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    protected void setX(int x){
        this.x = x;
    }

    protected void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void addCollider(Collider collider){
        this.collider = collider;
        this.collider.setGameObject(this);
    }

    public Collider getCollider(){
        return collider;
    }

    public SpriteSheet getSpriteSheet(){
        return spriteSheet;
    }
}
