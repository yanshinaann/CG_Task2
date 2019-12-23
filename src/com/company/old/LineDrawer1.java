package com.company.old;

import com.company.pixelDrawers.PixelDrawer;

import java.awt.*;

public interface LineDrawer1 {
    void setPixelDrawer(PixelDrawer pd);
    void drawLine(int x1, int y1, int x2, int y2, Color c);//усовершенствовать без pd, c
}
