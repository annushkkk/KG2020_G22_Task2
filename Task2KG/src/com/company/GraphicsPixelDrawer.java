package com.company;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
private Graphics gr;
public  GraphicsPixelDrawer(Graphics gr){
    this.gr=gr;
}

    @Override
    public void colorPixel(int x, int y, Color c) {
        gr.setColor(c);

        gr.fillRect(x,y,1,1);
    }
}
