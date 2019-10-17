package com.company.lineDrawers;

import com.company.pixelDrawers.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    PixelDrawer pd;
    Graphics2D g;
    public void setPixelDrawer(PixelDrawer pd){
        this.pd = pd;
    }
    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
        int dx = (x2 - x1);
        int dy = (y2 - y1);
        int D = Math.max(Math.abs(dx), Math.abs(dy));
        double stepY = (double) dy / D;
        double stepX = (double) dx / D;
        if ((dx == 0) && (dy == 0)) pd.drawPixel(x1, y1, c);
        else {
            for (int i = 0; i <= D; i++) {
                pd.drawPixel(x1 + (int) (stepX * i), y1 + (int) (stepY * i), c);
            }
        }
    }


}
