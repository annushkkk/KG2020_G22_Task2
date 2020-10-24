package com.company;

import com.company.pixel_lines.BresenhamLineDrawer;
import com.company.pixel_lines.DDALineDrawer;
import com.company.pixel_lines.WuLineDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point2D position = new Point(0,0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi  = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        super.paint(g);
        Graphics gr=bi.createGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0,0,getWidth(),getHeight());

        gr.setColor(Color.BLACK);
        PixelDrawer pd = new GraphicsPixelDrawer(gr);
        LineDrower ld=new DDALineDrawer(pd);

       ld.drawLine(getWidth()/2,0,getWidth()/2,getHeight());

        LineDrower ld1=new WuLineDrawer(pd);

        drawAll(ld1);





        g.drawImage(bi,0,0,null);
        gr.dispose();
    }
    private void drawAll(LineDrower ld){
       // drawSnowflake(ld,getWidth()/2,getHeight()/2,160,32);
          ld.drawLine(getWidth()/2,getHeight()/2,(int)position.getX(),(int)position.getY());
        //ld.drawLine(getWidth()/2,getHeight()/2,getWidth()/2+15,getHeight()/2+200);
       // ld.drawLine(getWidth()/2,getHeight()/2,getWidth()/2+2,getHeight()/2-10);


    }
    public static  void drawSnowflake(LineDrower ld,int x, int y,int r, int n){
        double da =2*Math.PI/n;
        for (int i=0;i<n;i++){
            double a=da*i;
            double dx=r*Math.cos(a);
            double dy=r*Math.sin(a);
            ld.drawLine(x,y,x+(int)dx,y+(int)dy);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
      position = new Point(e.getX(),e.getY());
      repaint();
    }
}
