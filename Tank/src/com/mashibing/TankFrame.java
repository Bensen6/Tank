package com.mashibing;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.invoke.SwitchPoint;

public class TankFrame extends Frame {
    int x= 200;
    int y = 200;
    Dir dir = Dir.DOWN;
    private static final int speed = 10;

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
        switch(dir){
            case LEFT:
              x -= 10;
              break;
              case RIGHT:
              x += 10;
              break;
              case UP:
              y -= 10;
              break;
            case DOWN:
              y += 10;
              break;
              default:
              break;
        }
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
                case 37:
                    x -= 10;
                    bl = true;
                    break;
                case 39:
                    x += 10;
                    br = true;
                    break;
                case 38:
                    bu = true;
                    break;
                case 40:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case 37:
                    bl = false;
                    break;
                case 39:
                    br = false;
                    break;
                case 38:
                    bu = false;
                    break;
                case 40:
                    bd = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }
        private void setMainTankDir(){
            if(bl) dir = Dir.LEFT;
            if(br) dir = Dir.RIGHT;
            if(bu) dir = Dir.UP;
            if(bd) dir = Dir.DOWN;
        };

    }


}


