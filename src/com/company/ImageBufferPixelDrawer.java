package com.company;

import com.company.PixelDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageBufferPixelDrawer implements PixelDrawer {

    public ImageBufferPixelDrawer(BufferedImage bi) {
        this.bi = bi;
    }

    private BufferedImage bi;

    @Override
   public Color getColorPixel(int x, int y){
        return new Color(bi.getRGB(x,y));
    };

    @Override
    public void drawPixel(int x, int y, Color c) {
        bi.setRGB(x, y, c.getRGB());
    }
}
