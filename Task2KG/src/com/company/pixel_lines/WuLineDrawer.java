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

//    @Override
//    public void drawLine(int x1, int y1, int x2, int y2) {
//        drawLine(x1, y1, x2, y2, Color.BLACK);
//    }
//

//    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
//        boolean isLineVerticallyOriented = Math.abs(y2 - y1) > Math.abs(x2 - x1);
//        if (isLineVerticallyOriented) {
//            int temp = y1;
//            y1 = x1;
//            x1 = temp;
//            temp = y2;
//            y2 = x2;
//            x2 = temp;
//        }
//        if (x1 > x2) {
//            int temp = y2;
//            y2 = y1;
//            y1 = temp;
//            temp = x2;
//            x2 = x1;
//            x1 = temp;
//        }

//        pd.colorPixel(x1, y1, color, isLineVerticallyOriented);
//        pd.colorPixel(x2, y2, color, isLineVerticallyOriented);
//        double dx = x2 - x1;
//        double dy = y2 - y1;
//        double slopeCoefficient = dy / dx;
//        double y = y1 + slopeCoefficient;
//        for (int x = x1 + 1; x <= x2 - 1; x++) {
//            pd.colorPixel(
//                    x,
//                    (int) y,
//                    new Color(
//                            color.getRed(),
//                            color.getGreen(),
//                            color.getBlue(),
//                            (int) (255 * (1 - y + (int) y))
//                    ),
//                    isLineVerticallyOriented
//            );
//            pd.colorPixel(
//                    x,
//                    (int) y + 1,
//                    new Color(
//                            color.getRed(),
//                            color.getGreen(),
//                            color.getBlue(),
//                            (int) (255 * (y - (int) y))
//                    ),
//                    isLineVerticallyOriented
//            );
//            y += slopeCoefficient;
//        }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
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

        float tg;
        if (Dx != 0) {
          tg=  Math.abs((float) Dy / Dx);
        } else {
            tg = Dy;
        }
        Color b1, b2;
        float y_line = tg * sign + y1;
        float x_line = 1 / tg + x1;

        if (Math.abs(Dy) <= Math.abs(Dx)) {
            pd.colorPixel(x1, y1, Color.BLACK);
            x++;
            for (int i = 1; i <= Dx; i++) {

                b1 = SetColor(y_line - (int) (y_line));
                b2 = SetColor(1 - (y_line - (int) (y_line)));
                if (sign < 0) {
                    Color c = b1;
                    b1 = b2;
                    b2 = c;
                }
                pd.colorPixel(x, (int) y_line + sign, b2);
                pd.colorPixel(x, (int) y_line, b1);
                System.out.println("y_line");
                System.out.println(y_line);
                y_line += tg * sign;
                x++;

            }
        } else {
            pd.colorPixel(x1, y1, Color.BLACK);
            y += sign;
            for (int i = 1; i <= Math.abs(Dy); i++) {

                b1 = SetColor(x_line - (int) (x_line));
                b2 = SetColor(1 - (x_line - (int) (x_line)));

                pd.colorPixel((int) x_line + 1, y, b2);
                pd.colorPixel((int) x_line, y, b1);
                System.out.println("xline");
                System.out.println(x_line);
                x_line += 1 / tg;
                y += sign;
            }
        }
    }

    private Color SetColor(float t) {
        int c = (int) (255 * t);
        Color res = new Color(c, c, c);
        return res;
    }
}

