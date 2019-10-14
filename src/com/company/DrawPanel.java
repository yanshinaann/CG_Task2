package com.company;

import com.company.lineDrawers.BresenhamLineDrawer;
import com.company.lineDrawers.DDALineDrawer;
import com.company.lineDrawers.LineDrawer;
import com.company.lineDrawers.WuLineDrawer;
import javafx.scene.shape.DrawMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener {
    private int cx = 500, cy = 500;
    private PixelDrawer pd;
    private Switch switch1 = Switch.BREZ;
    private boolean isMouseLineActive = true;

    DrawPanel() {
        super();
        this.addMouseMotionListener(this);
        this.addKeyListener(this);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        BufferedImage bj = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        PixelDrawer pd = new ImageBufferPixelDrawer(bj);

        //LineDrawer ld = new DDALineDrawer();
        //LineDrawer ld = new BresenhamLineDrawer(pd);
       LineDrawer ld = new WuLineDrawer();
        int color = Color.HSBtoRGB(0, 1, 1f);
//        switch (switch1) {
//            case DDA:
//                ld = new DDALineDrawer(pd);
//                break;
//            case WU:
//                ld = new WuLineDrawer(pd);
//                break;
//            case BREZ:
//                ld = new BresenhamLineDrawer(pd);
//        }
//
        if (ld != null) {
            ld.setPixelDrawer(pd);
        }
        ld.drawLine(getWidth() / 2, getHeight() / 2, cx, cy, new Color(color));
        //ld.drawLine( getWidth()/2, getHeight()/2, 300, 500 , Color.BLUE);

//        EllipseDrawer ed = new BresenhamEllipse();
//        ed.drawCircle(pd, 200, 400, 300, Color.BLUE);
        gr.drawImage(bj, 0, 0, null);
        //drawLine(pd, 10, 10, 10, 10, Color.BLUE);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cx = e.getX();
        cy = e.getY();
        this.repaint();
    }

    private LineDrawer ld;

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'D') {
            ld = new DDALineDrawer(pd);
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'd') {
            switch1 = Switch.DDA;
        } else if (keyEvent.getKeyChar() == 'b') {
            switch1 = Switch.BREZ;
        } else if (keyEvent.getKeyChar() == 'w') {
            switch1 = Switch.WU;
        } else if (keyEvent.getKeyChar() == 'm') {
            isMouseLineActive = !isMouseLineActive;
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

//    public static void drawLine(PixelDrawer pd, int x1, int y1, int x2, int y2, Color c) {
////        for(int i=x1; i<=x2; i++){
////            pd.drawPixel(i, y1, c);
////        }//горизонтальная линия
//
////        for (int i = y1; i <= y2; i++) {
////            pd.drawPixel(x1, i, c);
////        }//вертикальная линия
//        //step Y = dy/dx
//
//        int dx = (x2 - x1);
//        int dy = (y2 - y1);
//        int D = Math.max(Math.abs(dx), Math.abs(dy));
//        double stepY = (double) dy / D;
//        double stepX = (double) dx / D;
//        if ((dx == 0) && (dy == 0)) pd.drawPixel(x1, y1, c);
//        else {
//            for (int i = 0; i <= D; i++) {
//                pd.drawPixel(x1 + (int) (stepX * i), y1 + (int) (stepY * i), c);
//            }
//        }
//
//    }

    /*
    3: брезенхем ву - 1 линия
    4: эллипс и арка брезенхем и ву(для эллиспса другой алгоритм - и все доводим до пирожка
    5: закрасить пирожок и эллипс закрасить так, чтобы применялся алгоритм ву
     */

    /*
    добавить кнопочки, чтобы выбирать, каким алгоритмом рисовать
    с зажатой -
    а брезенхем
    б - дда
    в - ву

     */

}
