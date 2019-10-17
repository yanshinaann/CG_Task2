package com.company;

import com.company.lineDrawers.*;
import com.company.pixelDrawers.ImageBufferPixelDrawer;
import com.company.pixelDrawers.PixelDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener, MouseListener {
    private int cx = 500, cy = 500;
    private PixelDrawer pd;
  //private Switch switch1 = Switch.BREZ;
    private boolean isMouseLineActive = true;
    private LineDrawer ld;
    private BufferedImage bufferedImage;


    DrawPanel() throws HeadlessException {
        super();
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        this.addMouseListener(this);

    }

    @Override
    public void paint(Graphics g) {

        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        pd = new ImageBufferPixelDrawer(bufferedImage);

        if (i % 2 == 0) {
            ld = new BresenhamLineDrawer(pd);
        } else ld = new Wu();

        if (pd != null) ld.setPixelDrawer(pd);
        ld.drawLine(getWidth() / 2, getHeight() / 2, cx, cy, Color.YELLOW);
        g.drawImage(bufferedImage, 0, 0, null);

        //LineDrawer ld = new DDALineDrawer();
        //LineDrawer ld = new BresenhamLineDrawer(pd);
        // LineDrawer ld = new Wu();
//// Graphics2D gr = (Graphics2D) g;
// switch (switch1) {
//            case DDA:
//                ld = new DDALineDrawer(pd);
//                break;
//            case WU:
//                ld = new WuLineDrawer();
//                break;
//            case BREZ:
//                ld = new BresenhamLineDrawer(pd);
//                break;
//        }

//        if (ld != null) {
//            ld.setPixelDrawer(pd);
//        }
        //  int color = Color.HSBtoRGB(0, 1, 1f);
        //  ld.drawLine(getWidth() / 2, getHeight() / 2, cx, cy, Color.YELLOW);
        // ld.drawLine( 45, 70, 20, 300, Color.BLACK);
        //ld.drawLine( getWidth()/2, getHeight()/2, 300, 500 , Color.BLUE);
//        if (isMouseLineActive)


//        EllipseDrawer ed = new BresenhamEllipse();
//        ed.drawCircle(pd, 200, 400, 300, Color.BLUE);
        // gr.drawImage(bufferedImage, 0, 0, null);
        //drawLine(pd, 10, 10, 10, 10, Color.BLUE);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (isMouseLineActive) {
            cx = e.getX();
            cy = e.getY();
            this.repaint();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
//        if (keyEvent.getKeyChar() == 'd') {
//            switch1 = Switch.DDA;
//        } else if (keyEvent.getKeyChar() == 'b') {
//            switch1 = Switch.BREZ;
//        } else if (keyEvent.getKeyChar() == 'w') {
//            switch1 = Switch.WU;
//        } else if (keyEvent.getKeyChar() == 'm') {
//            isMouseLineActive = !isMouseLineActive;
//        }
//        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private int i = 1;

    @Override
    public void mouseClicked(MouseEvent e) {
        i++;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
