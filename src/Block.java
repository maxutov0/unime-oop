import java.awt.Color;
import java.awt.Graphics;

class Block { 
    // building element for Figure
    private int x, y;

    public Block(int x, int y) {
        setX(x);
        setY(y);
    }

    void setX(int x) { this.x = x; }
    void setY(int y) { this.y = y; }

    int getX() { return x; }
    int getY() { return y; }

    void paint(Graphics g, int color) {
        g.setColor(new Color(color));
        g.drawRoundRect(x*Constants.BLOCK_SIZE+1, y*Constants.BLOCK_SIZE+1, Constants.BLOCK_SIZE-2, Constants.BLOCK_SIZE-2, Constants.ARC_RADIUS, Constants.ARC_RADIUS);
    }
}