package com.company;

import java.awt.*;

public interface PixelDrawer {
    void colorPixel(int x, int y, Color c);
//    default void colorPixel(int x, int y) {
//        colorPixel(x, y, Color.BLACK);
//    }
//
//    default void colorPixel(int x, int y, boolean revert) {
//        colorPixel(revert ? y : x, revert ? x : y);
//    }
//
//    void colorPixel(int x, int y, Color color);
//
//    default void colorPixel(int x, int y, Color color, boolean revert) {
//        colorPixel(revert ? y : x, revert ? x : y, color);
//    }
}
