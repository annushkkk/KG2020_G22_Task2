package com.company.pixel_lines;

import com.company.LineDrower;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrower {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }



    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int sign =1;
        if (x1>x2){
            int c = x1;
            x1= x2;
            x2=c;
            c=y1;
            y1=y2;
            y2=c;
        }
        if(y1>y2){
            sign*=-1;
        }
        int x = x1;
        int y = y1;
        int Dx = x2 - x1;
        int Dy = y2 - y1;
        int e = 2 * Dy*sign  - Dx;


        if(Math.abs(Dy)<=Math.abs(Dx)){
        for (int i = 1; i <= Dx; i++) {
            pd.colorPixel(x, y, Color.BLUE);


            if (e >= 0) {
                y+=sign;
                e += -2 * Dx + (2 * Dy)*sign;
            } else
                e += (sign)*2 * Dy;
            x++;
        }} else{
            for (int i = 1; i <= Math.abs(Dy); i++) {
                pd.colorPixel(x, y, Color.RED);


                if (e >= 0) {
                    x++;
                    e += -2 * Dy* sign + 2 * Dx;
                } else
                    e += 2 * Dx;
                y+=sign;
            }
        }
    }
}
