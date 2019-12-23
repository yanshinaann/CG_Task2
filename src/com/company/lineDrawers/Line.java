package com.company.lineDrawers;

import com.company.old.LineDrawer1;

import java.awt.*;

public class Line {
    private int x1;
    private int x2;
    private int y2;
    private int y1;
    private LineDrawer1 ld;

    public Line(int x1, int x2, int y2, int y1, LineDrawer1 ld) {
        this.x1 = x1;
        this.x2 = x2;
        this.y2 = y2;
        this.y1 = y1;
        this.ld = ld;
    }
    private void draw(){
       ld.drawLine( x1, x2, y1, y2, Color.YELLOW);

    }
}
