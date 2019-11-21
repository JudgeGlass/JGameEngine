package net.judgeglass.tilegame.player;

import net.judgeglass.tilegame.world.WorldGen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerMovement extends KeyAdapter {

    private Player player;

    public PlayerMovement(Player player){
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_W:
                WPressEvent();
                break;
            case KeyEvent.VK_S:
                SPressEvent();
                break;
            case KeyEvent.VK_A:
                APressEvent();
                break;
            case KeyEvent.VK_D:
                DPressEvent();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
        }
    }

    private void WPressEvent(){
        WorldGen.yOff += 16;
    }

    private void SPressEvent(){
        WorldGen.yOff -= 16;
    }

    private void APressEvent(){
        WorldGen.xOff += 16;
    }

    private void DPressEvent(){
        WorldGen.xOff -= 16;
    }
}
