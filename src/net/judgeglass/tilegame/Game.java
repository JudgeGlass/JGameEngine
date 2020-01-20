package net.judgeglass.tilegame;

import net.judgeglass.jgameengine.gfx.PixelDrawer;
import net.judgeglass.jgameengine.gfx.RenderComponent;
import net.judgeglass.tilegame.player.Player;
import net.judgeglass.tilegame.player.PlayerMovement;
import net.judgeglass.tilegame.ui.HUD;
import net.judgeglass.tilegame.world.TestBlock;
import net.judgeglass.jgameengine.core.io.SpriteSheet;
import net.judgeglass.jgameengine.gfx.Screen;

import javax.swing.*;
import java.awt.*;

public class Game {

    /***
     * This is a test game for JGameEngine
     * ***/

    public static SpriteSheet spriteSheet;

    public static void main(String args[]){
        /*Screen gameScreen = new Screen(600, 480, "Tile Game v0.0.1 (Hunter Wilcox)");
        gameScreen.setClearColor(0x0000FF);
        spriteSheet = new SpriteSheet("res/sprites.png", 8, 8);
        TestBlock testBlock = new TestBlock(20, 20);
        PlayerMovement playerMovement = new PlayerMovement(new Player(0, 0));
        gameScreen.getRenderer().setKeyListener(playerMovement);
        //gameScreen.getRenderer().setThreadSleep(28);

        HUD hud = new HUD();*/

        JFrame frame = new JFrame("Hello world");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);

        RenderComponent renderComponent = new RenderComponent(600, 600);
        renderComponent.setBounds(30, 30, 600, 600);
        frame.add(renderComponent);

        spriteSheet = new SpriteSheet("res/sprites.png", 8, 8);
        TestBlock testBlock = new TestBlock(20, 20);
        PlayerMovement playerMovement = new PlayerMovement(new Player(0, 0));
        renderComponent.setKeyListener(playerMovement);
        //gameScreen.getRenderer().setThreadSleep(28);

        HUD hud = new HUD();

        frame.setVisible(true);
        renderComponent.start();
    }
}
