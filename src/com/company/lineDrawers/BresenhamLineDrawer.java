package com.company.lineDrawers;


import com.company.pixelDrawers.PixelDrawer;

import java.awt.*;

import static java.lang.Math.abs;

public class BresenhamLineDrawer implements LineDrawer {
    PixelDrawer pd;
    Graphics2D g;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    public void setPixelDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    private int sign(int x) {
        return Integer.compare(x, 0);
        //возвращает 0, если аргумент (x) равен нулю; -1, если x < 0 и 1, если x > 0.
    }

    @Override
    public void drawLine(int xstart, int ystart, int xend, int yend, Color c) {
        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;

        dx = xend - xstart;
        dy = yend - ystart;

        incx = sign(dx);
        incy = sign(dy);

        dx = Math.abs(dx);
        dy = Math.abs(dy);
        if (dx > dy) //определяем наклон отрезка:
        {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        } else//случай, когда прямая скорее "высокая", чем длинная, т.е. вытянута по оси y
        {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;//тогда в цикле будем двигаться по y
        }

        x = xstart;
        y = ystart;
        err = el / 2;
        pd.drawPixel(x, y, c);//ставим первую точку

        for (int t = 0; t < el; t++)//идём по всем точкам
        {
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;//сместить вверх или вниз, если по х
                y += incy;//сместить влево-вправо, если по y
            } else {
                x += pdx;
                y += pdy;
            }

            pd.drawPixel(x, y, c);
        }
    }


//
//    int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;
//
//    dx = xend - xstart;
//    dy = yend - ystart;
//
//    incx = sign(dx);
//    /*
//     * Определяем, в какую сторону нужно будет сдвигаться. Если dx < 0, т.е. отрезок идёт
//     * справа налево по иксу, то incx будет равен -1.
//     * Это будет использоваться в цикле постороения.
//     */
//    incy = sign(dy);
//    /*
//     * Аналогично. Если рисуем отрезок снизу вверх -
//     * это будет отрицательный сдвиг для y (иначе - положительный).
//     */
//
//    dx = Math.abs(dx);
//    dy = Math.abs(dy);
//        if (dx > dy) //определяем наклон отрезка:
//    {
//        /*
//         * Если dx > dy, то значит отрезок "вытянут" вдоль оси икс
//         * Значит в цикле нужно будет идти по икс (строчка el = dx;), значит "протягивать" прямую по иксу
//         * надо в соответствии с тем, слева направо и справа налево она идёт (pdx = incx;), при этом
//         * по y сдвиг такой отсутствует.
//         */
//        pdx = incx;
//        pdy = 0;
//        es = dy;
//        el = dx;
//    } else//случай, когда прямая скорее "высокая", чем длинная, т.е. вытянута по оси y
//    {
//        pdx = 0;
//        pdy = incy;
//        es = dx;
//        el = dy;//тогда в цикле будем двигаться по y
//    }
//
//    x = xstart;
//    y = ystart;
//    err = el / 2;
//        pd.drawPixel(x, y, c);//ставим первую точку
//
//        for (int t = 0; t < el; t++)//идём по всем точкам
//    {
//        err -= es;
//        if (err < 0) {
//            err += el;
//            x += incx;//сместить вверх или вниз, если по х
//            y += incy;//сместить влево-вправо, если по y
//        } else {
//            x += pdx;// сдвинуть влево или вправо, если по х
//            y += pdy;//сдвинуть вверх или вниз, если по х
//        }
//
//        pd.drawPixel(x, y, c);
//    }
//}

//       public void drawLineVariant1(int x0, int y0, int x1, int y1, Color c) {
//        int dx = abs(x1 - x0);
//        int dy = abs(y1 - y0);
//        int error = 0;
//        int derror = dy;
//        int y = y0;
//        int diry = y1 - y0;
//        if (diry > 0) {
//            diry = 1;
//        }
//        if (diry < 0) {
//            diry = -1;
//        }
//        for (int i = x0; i < x1; i++) {
//            pd.drawPixel(i, y, c);
//            error = error + derror;
//            if (2 * error >= dx) {
//                y = y + diry;
//                error = error - dx;
//            }
//        }
//    }
//
//
//    public void drawLineVariant2(PixelDrawer pd, int x1, int y1, int x2, int y2, Color c) {
//        int x = x1;
//        int y = y1;
//        int dx = x2 - x1;
//        int dy = y2 - y1;
//        int e = 2 * Math.abs(dy) - Math.abs(dx);
//        for (int i = 0; i < Math.abs(dx); i++) {
//            pd.drawPixel(x, y, c);
//            if (e >= 0) {
//                y++;
//                e += 2 * (Math.abs(dy) - Math.abs(dx));
//
//            } else {
//                e += 2 * Math.abs(dy);
//            }
//            x++;
//        }
//
//    }


}
