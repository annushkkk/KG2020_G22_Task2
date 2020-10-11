package com.company.pixel_lines;

import com.company.LineDrower;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrower {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int sign = 1;
        int x = x1;
        int y = y1;
        int Dx = x2 - x1;
        int Dy = y2 - y1;
        int e = 2 * Dy * sign - Dx;
        float d;
        Color b1, b2;

        for (int i = 1; i <= Dx; i++) {
            System.out.println("dx");
            System.out.println(Dx);
            System.out.println("dy");
            System.out.println(Dy);
            d = -1F * e / (Dy + Dx) / 1.15F;
            System.out.println("d");
            System.out.println(d);
            System.out.println("e");
            System.out.println(e);
            if (e >= 0) {

                b1 = SetColor(1F / 2 - d);
                b2 = SetColor(1F / 2 + d);
                pd.colorPixel(x, y, b1);
                pd.colorPixel(x, y + 1, b2);

                y += sign;
                e += -2 * Dx + (2 * Dy) * sign;
            } else {
                b1 = SetColor(1F / 2 + d);
                b2 = SetColor(1F / 2 - d);
                pd.colorPixel(x, y, b2);
                pd.colorPixel(x, y - 1, b1);
                e += (sign) * 2 * Dy;
            }
            x++;
        }
//        if (x1 > x2) {
//            int c = x1;
//            x1 = x2;
//            x2 = c;
//            c = y1;
//            y1 = y2;
//            y2 = c;
//        }
//        if (y1 > y2) {
//            sign *= -1;
//        }
//        int x = x1;
//        int y = y1;
//        int Dx = x2 - x1;
//        int Dy = y2 - y1;
//        int e = 2 * Dy * sign - Dx;
//        float d;
//        Color b1, b2;
//        if(y2>y1&&x2>x1){
//        if (Math.abs(Dy) <= Math.abs(Dx)) {
//            for (int i = 1; i <= Dx; i++) {
//                d = -1F * e / (Dy + Dx) / 1.15F;
//
//                if (e >= 0) {
//
//                    b1 = SetColor(1F / 2 - d);
//                    b2 = SetColor(1F / 2 + d);
//                    pd.colorPixel(x, y, b1);
//                    pd.colorPixel(x, y + 1, b2);
//
//                    y += sign;
//                    e += -2 * Dx + (2 * Dy) * sign;
//                } else {
//                    b1 = SetColor(1F / 2 + d);
//                    b2 = SetColor(1F / 2 - d);
//                    pd.colorPixel(x, y, b1);
//                    pd.colorPixel(x, y - 1, b2);
//                    e += (sign) * 2 * Dy;
//                }
//                x++;
//            }
//        } else {
//            for (int i = 1; i <= Math.abs(Dy); i++) {
//                d = -1F * e / (Dy + Dx) / 1.15F;
//
//
//                if (e >= 0) {
//                    b1 = SetColor(1F / 2 - d);
//                    b2 = SetColor(1F / 2 + d);
//                    pd.colorPixel(x, y, b1);
//                    pd.colorPixel(x, y + 1, b2);
//                    x++;
//                    e += -2 * Dy * sign + 2 * Dx;
//                } else{
//                    e += 2 * Dx;
//                    b1 = SetColor(1F / 2 + d);
//                    b2 = SetColor(1F / 2 - d);
//                    pd.colorPixel(x, y, b1);
//                    pd.colorPixel(x, y - 1, b2);
//                }
//                y += sign;
//            }
//        }}
    }

    private Color SetColor(float t) {
        int c = (int) (255 * t);
        System.out.println("t"); System.out.println(t);
            System.out.println("c"); System.out.println(c);
       // Color res = new Color(0, 53, 32, c);

        return Color.CYAN;
    }
}

