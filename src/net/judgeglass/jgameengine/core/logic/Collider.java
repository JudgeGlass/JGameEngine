package net.judgeglass.jgameengine.core.logic;

import net.judgeglass.jgameengine.core.entity.GameObject;

import java.awt.*;

public class Collider {
    private int x;
    private int y;
    private int w;
    private int h;
    private Rectangle hitBox;
    private String objName;
    private GameObject object;

    public Collider(int x, int y, int w, int h, String objName){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.objName = objName;

        hitBox = new Rectangle(x, y, w, h);
    }

    public boolean intersects(int x, int y, int w, int h){
        return hitBox.intersects(new Rectangle(x, y, w, h));
    }

    public boolean contains(int x, int y){
        return hitBox.contains(x, y);
    }

    public String getObjName(){
        return objName;
    }

    public GameObject getGameObject(){
        return object;
    }

    public void setGameObject(GameObject obj){
        this.object = obj;
    }
}
