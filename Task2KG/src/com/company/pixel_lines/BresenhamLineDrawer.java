package com.company.pixel_lines;

import com.company.LineDrower;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrower {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
//    @Override
//    public void drawLine(int x1, int y1, int x2, int y2) {
//        drawLine(x1, y1, x2, y2, Color.BLUE);
//    }
//    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
//        int delta = 0;
//
//        int lengthX = Math.abs(x2 - x1);
//        int lengthY = Math.abs(y2 - y1);
//
//        int doubledLengthX = 2 * lengthX;
//        int doubledLengthY = 2 * lengthY;
//
//        int directionX = x1 < x2 ? 1 : -1;
//        int directionY = y1 < y2 ? 1 : -1;
//
//        int x = x1;
//        int y = y1;
//
//        if (lengthX >= lengthY) {
//            while (true) {
//                pd.colorPixel(x, y, color);
//                if (x == x2)
//                    break;
//                x += directionX;
//                delta += doubledLengthY;
//                if (delta > lengthX) {
//                    y += directionY;
//                    delta -= doubledLengthX;
//                }
//            }
//            return;
//        }
//
//        while (true) {
//            pd.colorPixel(x, y, color);
//            if (y == y2)
//                break;
//            y += directionY;
//            delta += doubledLengthX;
//            if (delta > lengthY) {
//                x += directionX;
//                delta -= doubledLengthY;
//            }
//        }
//
//    }}


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
            for (int i = 0; i <= Dx; i++) {
                pd.colorPixel(x, y, Color.BLUE);
//                System.out.println('e');
//                System.out.println(e);
                if (e >= 0) {
                    y+=sign;
                    e += -2 * Dx + (2 * Dy)*sign;
                } else {
                    e += (sign)*2 * Dy;
                }

                x++;
            }
        } else{
           // pd.colorPixel(x, y, Color.BLUE);
                e=2*Dx-Dy*sign;
            for (int i = 0; i <= Math.abs(Dy); i++) {
//                System.out.println('e');
//                System.out.println(e);
                pd.colorPixel(x, y, Color.BLUE);
                if (e >= 0) {
                    x++;
                    e += -2 * Dy* sign + 2 * Dx;
                } else {
                    e += 2 * Dx;
                }

                y+=sign;
            }
        }
    }
}



