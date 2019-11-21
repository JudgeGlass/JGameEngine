package net.judgeglass.jgameengine.gfx;

import net.judgeglass.jgameengine.core.entity.Entity;
import net.judgeglass.jgameengine.core.entity.GameObject;
import net.judgeglass.jgameengine.core.input.Mouse;
import net.judgeglass.jgameengine.core.io.Log;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferStrategy;
import java.util.ConcurrentModificationException;

public class Renderer extends Canvas implements Runnable{
    private Screen screen;
    private Thread t;
    private boolean isRunning = false;
    private int fps;
    private int threadSleep = 2;
    private int counter = 20;

    public Renderer(final Screen screen){
        this.screen = screen;
        Mouse m = new Mouse();
        addMouseMotionListener(m);
        addMouseListener(m);
        requestFocus();
    }

    public void start(){
        t = new Thread(this);
        t.setName("Java Game Engine");
        t.start();
        Log.info("Render thread has started!");
    }

    public void setThreadSleep(int time){
        threadSleep = time;
    }
    public void setKeyListener(KeyAdapter keyListener){
        addKeyListener(keyListener);
        requestFocus();
    }

    @Override
    public void run() {
        isRunning = true;
        loop();
    }

    private void loop(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int frames = 0;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();

        while (isRunning) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            while (unprocessed >= 1) {
                ticks++;
                tick();
                unprocessed -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(threadSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (shouldRender) {
                frames++;
                render();
            }

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                Log.info(ticks + " ticks, " + frames + " fps\t\tMem: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024) / 1024 + " MB");
                //screen.setTitle(" FPS: " + frames);
                fps = frames;
                frames = 0;
                ticks = 0;
            }
        }

        stop();
    }

    public void drawPixel(int x, int y, int col){
        x--;
        y--;
        if(x < 0 || x > screen.getWidth() || y < 0 || y > screen.getHeight())
            return;

        if(x + y * screen.getWidth() > screen.pixels.length)
            return;
        screen.pixels[x + y * screen.getWidth()] = col;
    }

    public int getFps(){
        return fps;
    }

    private void stop(){
        try {
            Log.info("Attempting to kill render thread...");
            t.join();
        } catch (InterruptedException e) {
            Log.error("Failed to kill render thread!");
            e.printStackTrace();
        }
    }

    private void tick(){
        if(counter > 0){
            counter--;
            return;
        }

        try {
            for (GameObject go : Entity.getObjects()) {
                go.tick();
            }
        }catch (ConcurrentModificationException e){
            e.printStackTrace();
        }
    }

    private void render(){
        if(counter > 0){
            return;
        }
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        try {
            for (GameObject go : Entity.getObjects()) {
                go.render(screen);
            }
        }catch (ConcurrentModificationException e){
            e.printStackTrace();
        }

        g.drawImage(screen.getImage(), 0, 0, screen.getWidth(), screen.getHeight(), null);
        bs.show();
        g.dispose();
        screen.clear();
    }
}
