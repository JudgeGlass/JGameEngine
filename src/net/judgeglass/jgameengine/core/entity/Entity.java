package net.judgeglass.jgameengine.core.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entity {
    private static List<GameObject> objects = Collections.synchronizedList(new ArrayList<>());

    public static void add(GameObject object){
        objects.add(object);
    }

    public static List<GameObject> getObjects(){
        return objects;
    }
}
