package net.judgeglass.jgameengine.gfx;

import net.judgeglass.jgameengine.core.io.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {
    public static final String JGE_VERSION = "v0.0.2";


    private JFrame frame;
    private BufferedImage image;

    private int width;
    private int height;
    private int clearColor = 0x000000;
    private String title;
    private net.judgeglass.jgameengine.gfx.Renderer renderer;
    public int pixels[];

    public Screen(final int width, final int height, final String title){
        Log.info("JGameEngine " + JGE_VERSION + " - Copyright (c) 2018-2019 Hunter Wilcox");
        Log.info("Setting up screen components...");
        this.width  = width;
        this.height = height;
        this.title  = title;

        image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

        Log.info("Starting gfx renderer....");
        renderer = new net.judgeglass.jgameengine.gfx.Renderer(this);

        frame = new JFrame(this.title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(renderer, BorderLayout.CENTER);
        frame.setVisible(true);
        renderer.start();
    }

    public Screen(final int width, final int height){
        Log.info("JGameEngine " + JGE_VERSION + " - Copyright (c) 2018-2019 Hunter Wilcox");
        this.width = width;
        this.height = height;
        image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(final String title){
        this.title = title;
        frame.setTitle(title);
    }

    public void setRenderer(final Renderer renderer){
        this.renderer = renderer;
    }

    public Renderer getRenderer(){
        return renderer;
    }

    public void setClearColor(int clearColor){
        this.clearColor = clearColor;
    }

    public void clear(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = clearColor;
        }
    }

    public BufferedImage getImage(){
        return image;
    }
}
