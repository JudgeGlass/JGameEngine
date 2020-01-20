package net.judgeglass.jgameengine.gfx;

import javax.swing.*;

public class RenderComponent extends Renderer {
    public RenderComponent(int width, int height) {
        super(new Screen(width, height));
    }
}
