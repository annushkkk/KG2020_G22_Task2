package com.company.pixel_lines;

import com.company.LineDrower;
import com.company.PixelDrawer;

import java.awt.*;
import java.util.Set;

public class WuLineDrawer implements LineDrower {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        drawLine(x1, y1, x2, y2, Color.BLACK);
    }

    private void drawLine(int x1, int y1, int x2, int y2,Color color) {
        int sign = 1;
        if (x1 > x2) {
            int c = x1;
            x1 = x2;
            x2 = c;
            c = y1;
            y1 = y2;
            y2 = c;
        }
        if (y1 > y2) {
            sign *= -1;
        }
        int x = x1;
        int y = y1;
        int Dx = x2 - x1;
        int Dy = y2 - y1;

        float tg,obrtg;
        if (Dx != 0) {
          tg=  Math.abs((float) Dy / Dx);
        } else {
            tg = 0;
        }
        if (tg==0){
            obrtg=0;
        } else{
            obrtg=1/tg;
        }

        Color b1, b2;
        float y_line = y1 +sign*tg;
        float x_line = obrtg + x1;

        if (Math.abs(Dy) <= Math.abs(Dx)) {
            pd.colorPixel(x1, y1, color);

            x++;
            if (sign < 0) {
                y_line++;
            }
            for (int i = 1; i <= Dx; i++) {

                b1 = SetColor(y_line - (int) (y_line),color);

                b2 = SetColor(1 - (y_line - (int) (y_line)),color);

                if (sign < 0) {

                    Color c = b1;
                    b1 = b2;
                    b2 = c;
                }
                pd.colorPixel(x, (int) y_line + sign, b1);
                pd.colorPixel(x, (int) y_line, b2);

                y_line += tg * sign;
                x++;

            }
        } else {
            pd.colorPixel(x1, y1, color);
            pd.colorPixel(x2,y2,color);
            y += sign;
            for (int i = 1; i <= Math.abs(Dy); i++) {

                b1 = SetColor(x_line - (int) (x_line),color);
                b2 = SetColor(1 - (x_line - (int) (x_line)),color);

                pd.colorPixel((int) x_line + 1, y, b1);
                pd.colorPixel((int) x_line, y, b2);

                x_line += obrtg;
                y += sign;
            }
        }
    }

    private Color SetColor(float t, Color color) {
        int c = (int) (255 * t);
        Color res = new Color(color.getRed(),color.getGreen(), color.getBlue(), c);
        return res;
    }
}

