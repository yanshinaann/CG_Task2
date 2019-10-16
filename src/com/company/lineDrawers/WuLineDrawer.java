package com.company.lineDrawers;

import com.company.PixelDrawer;

import java.awt.*;

import static java.lang.Math.abs;
import static java.lang.Math.round;
import static java.lang.StrictMath.floor;


public class WuLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    @Override
    public void setPixelDrawer(PixelDrawer pixelDrawer) {
        this.pd = pixelDrawer;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color c) {

        pd.drawPixel(x1, y1, c);
        pd.drawPixel(x2, y2, c);

        if (Math.abs(y2 - y1) > Math.abs(x2 - x1)) {
            double dx = x2 - x1;
            double dy = y2 - y1;
            double gradient = dx / dy;
            double x = x1 + gradient;

            for (int y = y1 + 1; y <= y2 - 1; y++) {
                double t = 1 - (x - (int) x);
                Color d = setColor(c, t);
                pd.drawPixel((int) x, y, d);
                t = x - (int) x;
                d = setColor(c, t);
                pd.drawPixel((int) x + 1, y, d);
                x += gradient;
            }
        } else {
            double dx = x2 - x1;
            double dy = y2 - y1;

            double gradient = dy / dx;
            double y = y1 + gradient;
            int x = x1 + 1;

            for (x = x1 + 1; x <= x2 - 1; x++) {
                double t = 1 - (y - (int) y);
                Color d = setColor(c, t);
                pd.drawPixel(x, (int) y, d);
                t = y - (int) y;
                d = setColor(c, t);
                pd.drawPixel(x, (int) y + 1, d);
                y += gradient;

            }
        }

    }

    private Color setColor(Color c, double t) {
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        Color result = new Color(red, green, blue, (int) (255 * t));
        return result;
    }
//
//    @Override
//    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
//        if (x2 < x1) {
//            x1 += x2;
//            x2 = x1 - x2;
//            x1 -= x2;
//            y1 += y2;
//            y2 = y1 - y2;
//            y1 -= y2;
//        }
//        int dx = x2 - x1;
//        int dy = y2 - y1;
//        DDALineDrawer lineDrawer = new DDALineDrawer(pixelDrawer);
//        //Горизонтальные и вертикальные линии не нуждаются в сглаживании
//        if (dx == 0 || dy == 0) {
//            lineDrawer.drawLine(x1,y1,x2,y2,color);
//            return;
//        }
//        float gradient = 0;
//        if (dx > dy) {
//            gradient = (float) dy / dx;
//            float intery = y1 + gradient;
//            lineDrawer.drawLine(x1,y1,x2,y2,color);
//            for (int x = x1; x < x2; ++x) {
//                Color color1 = new Color(Color.HSBtoRGB(0, 1, (float) (255 - fractionalPart(intery) * 255))); //Меняем прозрачность
//                pixelDrawer.drawPixel(x, (int) intery, color1);
//                color1 = new Color(Color.HSBtoRGB(0, 1, (float) (fractionalPart(intery) * 255)));
//                pixelDrawer.drawPixel(x, (int) intery + 1,color1);
//                intery += gradient;
//            }
//            pixelDrawer.drawPixel(x2, y2, Color.BLACK);
//        } else {
//            gradient = (float) dx / dy;
//            float interx = x1 + gradient;
//            pixelDrawer.drawPixel(x1, y1, Color.black);
//            for (int y = y1; y < y2; ++y) {
//                Color color1 = new Color(Color.HSBtoRGB(0, 1, (float) (255 - fractionalPart(interx) * 255)));
//                pixelDrawer.drawPixel((int) interx, y, color1);
//                color1 = new Color(Color.HSBtoRGB(0, 1, (float) (fractionalPart(interx) * 255)));
//                pixelDrawer.drawPixel((int) interx + 1, y, color1);
//                interx += gradient;
//            }
//            pixelDrawer.drawPixel(x2,y2,Color.black);
//        }
//    }
//
//    private float fractionalPart(float x) {
//        int tmp = (int) x;
//        return x - tmp; //вернёт дробную часть числа
//    }
//

//    private PixelDrawer pixelDrawer;
//    LineDrawer ld = new DDALineDrawer(pixelDrawer);
//
//    public WuLineDrawer(PixelDrawer pixelDrawer) {
//        this.pixelDrawer = pixelDrawer;
//    }
//
//    @Override
//    public void setPixelDrawer(PixelDrawer pixelDrawer) {
//
//    }
//
//    @Override
//    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
//        if (x2 < x1) {
//            x1 += x2;
//            x2 = x1 - x2;
//            x1 -= x2;
//            y1 += y2;
//            y2 = y1 - y2;
//            y1 -= y2;
//        }
//        int dx = x2 - x1;
//        int dy = y2 - y1;
//
//        if (dx == 0 || dy == 0) { //Горизонтальные и вертикальные пиксели не нуждаются в сглаживании
//            ld.drawLine(x1, y1, x2, y2, c);
//
//            // pixelDrawer.drawPixel(x1, y1, c);
//            return;
//        }
//
//        float gradient;
//
//        if (dx > dy) {
//            gradient = (float) dy / dx;
//            float intery = y1 + gradient;
//            // ld.drawLine(x1, y1, x1, y1, c);
//            pixelDrawer.drawPixel(x1, y1, c);
//            Color color = new Color(Color.HSBtoRGB(0, 1, (int) (255 - fractionalPart(intery) * 255)));
//            for (int x = x1; x < x2; ++x) {
//
//                pixelDrawer.drawPixel(x, (int) intery, color);
//                pixelDrawer.drawPixel(x, (int) intery + 1, color);
//                intery += gradient;
//            }
//
//            // ld.drawLine(x2, y2, x2, y2, c);
//            pixelDrawer.drawPixel(x2, y2, color);
//        } else {
//            gradient = (float) dx / dy;
//            float interx = x1 + gradient;
//            Color color = new Color(Color.HSBtoRGB(0, 1, (int) (255 - fractionalPart(interx) * 255)));
//            //ld.drawLine(x1, y1, x1, y1, c);
//            pixelDrawer.drawPixel(x1, y1, c);
//            for (int y = y1; y < y2; ++y) {
//                pixelDrawer.drawPixel((int) interx, y, color);
//                pixelDrawer.drawPixel((int) interx + 1, y, color);
//                interx += gradient;
//            }
//            // ld.drawLine(x2, y2, x2, y2, c);
//            pixelDrawer.drawPixel(x2, y2, color);
//        }
//
//    }
//
//    private float fractionalPart(float x) {
//        int tmp = (int) x;
//        return x - tmp; //вернёт дробную часть числа
//    }
//    PixelDrawer p;
//
//    public WuLineDrawer(PixelDrawer p) {
//        this.p = p;
//    }
//    @Override
//    public void setPixelDrawer(PixelDrawer pixelDrawer) {
//
//    }
//    @Override
//    public void drawLine(int x1, int y1, int x2, int y2, Color c) {
//
//
//        LineDrawer ld = new BresenhamLineDrawer(p);
//
//        if (x2 < x1) {
//            int tempX, tempY;
//            tempX = x1;
//            x1 = x2;
//            x2 = tempX;
//
//
//            tempY = y1;
//            y1 = y2;
//            y2 = tempY;
//
//        }
//
//
//        int dx = x2 - x1;
//        int dy = y2 - y1;
//
//        float incline;
//
//        if (dx == 0 || dy == 0) {
//            ld.drawLine(x1, y1, x2, y2, c);
//
//
//            return;
//        }
//        float gradient = 0;
//        if (dx > dy) {
//            gradient = (float) dy / dx;
//
//            incline = y1 + gradient;
//
//            p.drawPixel(x1, y1, c);
//
//            for (int x = x1; x < x2; ++x) {
//
//
//                float d1 = fractionalPart(incline);
//                float d2 = 1 - d1;
//
//                p.drawPixel(x, (int) incline + 1, new Color(
//                        (int) (d2 * c.getRed() + d1 * p.getColorPixel(x, (int) incline + 1).getRed()),
//                        (int) (d2 * c.getGreen() + d1 * p.getColorPixel(x, (int) incline + 1).getGreen()),
//                        (int) (d2 * c.getBlue() + d1 * p.getColorPixel(x, (int) incline + 1).getBlue())));
//
//                p.drawPixel(x, (int) incline, new Color(
//                        (int) (d1 * c.getRed() + d2 * p.getColorPixel(x, (int) incline).getRed()),
//                        (int) (d1 * c.getGreen() + d2 * p.getColorPixel(x, (int) incline).getGreen()),
//                        (int) (d1 * c.getBlue() + d2 * p.getColorPixel(x, (int) incline).getBlue())));
//
//                incline += gradient;
//            }
//
//            p.drawPixel(x2, y2, c);
//        } else {
//            gradient = (float) dx / dy;
//            incline = x1 + gradient;
//            p.drawPixel(x1, y1, c);
//            for (int y = y1; y < y2; ++y) {
//
//
//                float d1 = fractionalPart(incline);
//                float d2 = 1 - d1;
//
//                p.drawPixel((int) incline + 1, y, new Color(
//                        (int) (d2 * c.getRed() + d1 * p.getColorPixel((int) incline + 1, y).getRed()),
//                        (int) (d2 * c.getGreen() + d1 * p.getColorPixel((int) incline + 1, y).getGreen()),
//                        (int) (d2 * c.getBlue() + d1 * p.getColorPixel((int) incline + 1, y).getBlue())));
//
//                p.drawPixel((int) incline, y, new Color(
//                        (int) (d1 * c.getRed() + d2 * p.getColorPixel((int) incline, y).getRed()),
//                        (int) (d1 * c.getGreen() + d2 * p.getColorPixel((int) incline, y).getGreen()),
//                        (int) (d1 * c.getBlue() + d2 * p.getColorPixel((int) incline, y).getBlue())));
//
//
//                incline += gradient;
//            }
//            p.drawPixel(x2, y2, c);
//        }
//
//    }
//
//    private float fractionalPart(float x) {
//        int tmp = (int) x;
//        return x - tmp; //вернёт дробную часть числа
//    }

//
//    @Override
//    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
//        drawLine(x1, y1, x2, y2);
//    }
//
//    void plot(double x, double y, double c) {
//        pixelDrawer.drawPixel((int) x, (int) y, Color.CYAN);
//    }
//
//    int ipart(double x) {
//        return (int) x;
//    }
//
//    double fpart(double x) {
//        return x - floor(x);
//    }
//
//    double rfpart(double x) {
//        return 1.0 - fpart(x);
//    }
//
//    void drawLine(double x0, double y0, double x1, double y1) {
//
//        boolean steep = abs(y1 - y0) > abs(x1 - x0);
//        if (steep)
//            drawLine(y0, x0, y1, x1);
//
//        if (x0 > x1)
//            drawLine(x1, y1, x0, y0);
//
//        double dx = x1 - x0;
//        double dy = y1 - y0;
//        double gradient = dy / dx;
//
//        // handle first endpoint
//        double xend = round(x0);
//        double yend = y0 + gradient * (xend - x0);
//        double xgap = rfpart(x0 + 0.5);
//        double xpxl1 = xend; // this will be used in the main loop
//        double ypxl1 = ipart(yend);
//
//        if (steep) {
//            plot(ypxl1, xpxl1, rfpart(yend) * xgap);
//            plot(ypxl1 + 1, xpxl1, fpart(yend) * xgap);
//        } else {
//            plot(xpxl1, ypxl1, rfpart(yend) * xgap);
//            plot(xpxl1, ypxl1 + 1, fpart(yend) * xgap);
//        }
//
//        // first y-intersection for the main loop
//        double intery = yend + gradient;
//
//        // handle second endpoint
//        xend = round(x1);
//        yend = y1 + gradient * (xend - x1);
//        xgap = fpart(x1 + 0.5);
//        double xpxl2 = xend; // this will be used in the main loop
//        double ypxl2 = ipart(yend);
//
//        if (steep) {
//            plot(ypxl2, xpxl2, rfpart(yend) * xgap);
//            plot(ypxl2 + 1, xpxl2, fpart(yend) * xgap);
//        } else {
//            plot(xpxl2, ypxl2, rfpart(yend) * xgap);
//            plot(xpxl2, ypxl2 + 1, fpart(yend) * xgap);
//        }
//
//        // main loop
//        for (double x = xpxl1 + 1; x <= xpxl2 - 1; x++) {
//            if (steep) {
//                plot(ipart(intery), x, rfpart(intery));
//                plot(ipart(intery) + 1, x, fpart(intery));
//            } else {
//                plot(x, ipart(intery), rfpart(intery));
//                plot(x, ipart(intery) + 1, fpart(intery));
//            }
//            intery = intery + gradient;
//        }
//    }


}
