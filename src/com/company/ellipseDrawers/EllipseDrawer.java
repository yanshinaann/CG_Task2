package com.company.ellipseDrawers;

import com.company.pixelDrawers.PixelDrawer;

import java.awt.*;

public interface EllipseDrawer {
    void drawCircle(PixelDrawer pd, int r, int x0, int y0, Color c);
}
