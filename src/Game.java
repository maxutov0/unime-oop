import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Game extends JFrame {    
    JFrame frame;
    
    protected int gameScore = 0;
    protected boolean gameOver = false;

    protected Figure figure = null;
    protected Canvas canvas = new Canvas();

    Game() {
        setTitle(Constants.TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(Constants.START_LOCATION, Constants.START_LOCATION, Constants.FIELD_WIDTH * Constants.BLOCK_SIZE + Constants.FIELD_DX, Constants.FIELD_HEIGHT * Constants.BLOCK_SIZE + Constants.FIELD_DY);
        setResizable(false);
        // make window in center of screen
        setLocationRelativeTo(null);

        canvas.setBackground(Color.black); // define the background color
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    if (e.getKeyCode() == Constants.DOWN) figure.drop();
                    if (e.getKeyCode() == Constants.UP) figure.rotate();
                    if (e.getKeyCode() == Constants.LEFT || e.getKeyCode() == Constants.RIGHT) figure.move(e.getKeyCode());
                }
                canvas.repaint();
            }
        });
        add(BorderLayout.CENTER, canvas);
        setVisible(true);
        Arrays.fill(Constants.mine[Constants.FIELD_HEIGHT], 1); // create a ground for mines
    }

    void start() { 
        if(figure == null) {
            figure = new Figure();
        }

        // main loop of game
        while (!gameOver) {
            try {
                Thread.sleep(Constants.SHOW_DELAY);
            } catch (Exception e) { 
                e.printStackTrace(); 
            }

            canvas.setFigure(figure);

            canvas.repaint();
            checkFilling();

            if (figure.isTouchGround()) {
                figure.leaveOnTheGround();
                figure = new Figure();
                gameOver = figure.isCrossGround(); // Is there space for a new figure?
            } else {
                figure.stepDown();
            }
        }

        canvas.setGameOver(gameOver);
        canvas.repaint();
    }

    void checkFilling() { 
        // check filling rows
        int row = Constants.FIELD_HEIGHT - 1;
        int countFillRows = 0;

        while (row > 0) {
            int filled = 1;
            for (int col = 0; col < Constants.FIELD_WIDTH; col++)
                filled *= Integer.signum(Constants.mine[row][col]);
            if (filled > 0) {
                countFillRows++;
                for (int i = row; i > 0; i--) System.arraycopy(Constants.mine[i-1], 0, Constants.mine[i], 0, Constants.FIELD_WIDTH);
            } else
                row--;
        }

        if (countFillRows > 0) {
            gameScore += Constants.SCORES[countFillRows - 1];
            setTitle(Constants.TITLE_OF_PROGRAM + " : " + gameScore);
        }
    }    
}