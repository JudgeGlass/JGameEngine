package net.judgeglass.jgameengine.core.input;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener, MouseInputListener {

    private static int x;
    private static int y;
    private static boolean mc1;

    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public static boolean isButton1Pressed(){
        return mc1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            mc1 = true;
        else
            mc1 = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mc1 = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
}
