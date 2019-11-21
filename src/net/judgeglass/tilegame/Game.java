package net.judgeglass.tilegame;

import net.judgeglass.tilegame.player.Player;
import net.judgeglass.tilegame.player.PlayerMovement;
import net.judgeglass.tilegame.ui.HUD;
import net.judgeglass.tilegame.world.TestBlock;
import net.judgeglass.jgameengine.core.io.SpriteSheet;
import net.judgeglass.jgameengine.gfx.Screen;

public class Game {

    /***
     * This is a test game for JGameEngine
     * ***/

    public static SpriteSheet spriteSheet;

    public static void main(String args[]){
        Screen gameScreen = new Screen(600, 480, "Tile Game v0.0.1 (Hunter Wilcox)");
        gameScreen.setClearColor(0x0000FF);
        spriteSheet = new SpriteSheet("res/sprites.png", 8, 8);
        TestBlock testBlock = new TestBlock(20, 20);
        PlayerMovement playerMovement = new PlayerMovement(new Player(0, 0));
        gameScreen.getRenderer().setKeyListener(playerMovement);
        gameScreen.getRenderer().setThreadSleep(14);







        HUD hud = new HUD();

    }
}
