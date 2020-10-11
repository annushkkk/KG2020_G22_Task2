package com.company.pixel_lines;

import com.company.LineDrower;
import com.company.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrower {
    private PixelDrawer pd;
    public  DDALineDrawer(PixelDrawer pd){
        this.pd=pd;
    }
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2-x1;
        double dy= y2-y1;

        if (Math.abs(dy)>Math.abs(dx)){
            double obrk = dx/dy;

            if(y1>y2){
                int tmp =y2;y2=y1;y1=tmp;
                tmp=x2;x2=x1;x1=tmp;
            }
             for(int i=y1;i<y2;i++){
                 double j = (i-y1)*obrk+x1;
                 pd.colorPixel((int)j,i, Color.RED);
             }
        } else{
            double k=dy/dx;
            if(x1>x2){
                int tmp =y2;y2=y1;y1=tmp;
                tmp=x2;x2=x1;x1=tmp;
            }
            for(int j=x1;j<x2;j++){
                double i = (j-x1)*k+y1;
                pd.colorPixel((int)j,(int)i, Color.BLUE);
            }

        }
    }
}
