import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class Canvas extends JPanel {
    // my canvas for painting
    
    protected Figure figure;
    protected boolean gameOver;
    
    @Override // means that we override method paint() from class JPanel
    public void paint(Graphics g) {
        super.paint(g);

        for (int x = 0; x < Constants.FIELD_WIDTH; x++) {
            for (int y = 0; y < Constants.FIELD_HEIGHT; y++) {
                if (x < Constants.FIELD_WIDTH - 1 && y < Constants.FIELD_HEIGHT - 1) {
                    g.setColor(Color.lightGray);
                    g.drawLine((x+1)*Constants.BLOCK_SIZE-2, (y+1)*Constants.BLOCK_SIZE, (x+1)*Constants.BLOCK_SIZE+2, (y+1)*Constants.BLOCK_SIZE);
                    g.drawLine((x+1)*Constants.BLOCK_SIZE, (y+1)*Constants.BLOCK_SIZE-2, (x+1)*Constants.BLOCK_SIZE, (y+1)*Constants.BLOCK_SIZE+2);
                }
                if (Constants.mine[y][x] > 0) {
                    g.setColor(new Color(Constants.mine[y][x]));
                    g.fill3DRect(x*Constants.BLOCK_SIZE+1, y*Constants.BLOCK_SIZE+1, Constants.BLOCK_SIZE-1, Constants.BLOCK_SIZE-1, true);
                }
            }
        }

        if(gameOver) {
            GameOver go = new GameOver();
            go.paint(g); 
        } else {
            figure.paint(g);
        }
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}