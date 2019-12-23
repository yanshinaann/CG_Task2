package com.company.old;

import com.company.pixelDrawers.PixelDrawer;

import java.awt.*;

public class BresenhamEllipse implements EllipseDrawer1 {
    @Override
    public void drawCircle(PixelDrawer pd, int r, int x0, int y0, Color c) {
        int x = 0;
        int y = r;
        int delta = 1 - 2 * r;
        int error = 0;
        while (y >= 0) {
            //       drawpixel(X1 + x, Y1 + y);
            //       drawpixel(X1 + x, Y1 - y);
            //       drawpixel(X1 - x, Y1 + y);
            pd.pixel(x+x0, y+y0, c);

            error = 2 * (delta + y) - 1;
            if ((delta < 0) && (error <= 0)) {
                delta += 2 * ++x + 1;
                continue;
            }
            if ((delta > 0) && (error > 0)) {
                delta -= 2 * --y + 1;
                continue;
            }
            delta += 2 * (++x - y--);
        }
    }

}
