package com.mashibing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x= 200;
    int y = 200;


    public TankFrame(){

        setVisible(true);
        setSize(800,600);
        setResizable(false);
        setTitle("tank war");
        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.print("paint");
        g.fillRect(x,y,50,50);
//        y += 10;
//        x += 10;
    }

    class MyKeyListener extends KeyAdapter{
        boolean bl = false;
        boolean br = false;
        boolean bu = false;
        boolean bd = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_KP_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_KP_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_KP_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_KP_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_KP_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_KP_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_KP_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_KP_DOWN:
                    bd = false;
                    break;
                default:
                    break;
            }
        }
    }

}


