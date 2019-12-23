package com.company.pixelDrawers;

import java.awt.*;

public interface PixelDrawer {

    void pixel(int x, int y, Color c);

    int getRGB(int x, int y);

    default Color mix(int x, int y, Color c, double brightness) {
        Color bck = new Color(getRGB(x, y));
        double r = (bck.getRed() * (1 - brightness) + c.getRed() * brightness);
        double g = (bck.getGreen() * (1 - brightness) + c.getGreen() * brightness);
        double b =  (bck.getBlue() * (1 - brightness) + c.getBlue() * brightness);
        return new Color((int) r, (int) g, (int) b);
    }
}
