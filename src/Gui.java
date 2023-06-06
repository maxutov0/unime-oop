import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gui extends JPanel {

    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 22;
    private static final int BLOCK_SIZE = 30;

    private boolean[][] board;
    // private Tetromino currentPiece;
    private Timer timer;
    private boolean isGameOver;

    public Gui() {
        board = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
        // currentPiece = new Tetromino();
        isGameOver = false;

        setPreferredSize(new Dimension(BOARD_WIDTH * BLOCK_SIZE, BOARD_HEIGHT * BLOCK_SIZE));
        setFocusable(true);

        addKeyListener(new TetrisKeyListener());

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isGameOver) {
                    movePieceDown();
                }
            }
        });
        timer.start();

        startGame();
    }

    private void startGame() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = false;
            }
        }

        // currentPiece = new Tetromino();
        isGameOver = false;
    }

    private void movePieceDown() {
        // if (currentPiece.canMove(board, 1, 0)) {
        //     currentPiece.move(1, 0);
        // } else {
        //     // Lock the current piece on the board
        //     currentPiece.lock(board);

        //     // Check for completed rows and clear them
        //     int clearedRows = clearCompletedRows();

        //     // Generate a new piece
        //     currentPiece = new Tetromino();

        //     // Check if the new piece overlaps with existing blocks
        //     if (!currentPiece.canMove(board, 0, 0)) {
        //         isGameOver = true;
        //         timer.stop();
        //     }
        // }

        repaint();
    }

    private void movePieceLeft() {
        // if (currentPiece.canMove(board, 0, -1)) {
        //     currentPiece.move(0, -1);
        //     repaint();
        // }
    }

    private void movePieceRight() {
        // if (currentPiece.canMove(board, 0, 1)) {
        //     currentPiece.move(0, 1);
        //     repaint();
        // }
    }

    private void rotatePiece() {
        // if (currentPiece.canRotate(board)) {
        //     currentPiece.rotate();
        //     repaint();
        // }
    }

    private int clearCompletedRows() {
        int clearedRows = 0;

        for (int row = BOARD_HEIGHT - 1; row >= 0; row--) {
            boolean isRowCompleted = true;

            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (!board[row][col]) {
                    isRowCompleted = false;
                    break;
                }
            }

            if (isRowCompleted) {
                // Clear the completed row
                for (int r = row; r > 0; r--) {
                    for (int col = 0; col < BOARD_WIDTH; col++) {
                        board[r][col] = board[r - 1][col];
                    }
                }

                // Clear the top row
                for (int col = 0; col < BOARD_WIDTH; col++) {
                    board[0][col] = false;
                }

                clearedRows++;
            }
        }

        return clearedRows;
    }

    private void drawPiece(Graphics g) {
        Color[] colors = {Color.CYAN, Color.YELLOW, Color.ORANGE, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED};

        // for (int row = 0; row < currentPiece.getSize(); row++) {
        //     for (int col = 0; col < currentPiece.getSize(); col++) {
        //         if (currentPiece.isBlockFilled(row, col)) {
        //             int x = currentPiece.getX() + col;
        //             int y = currentPiece.getY() + row;
        //             g.setColor(colors[currentPiece.getType()]);
        //             g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        //             g.setColor(Color.BLACK);
        //             g.drawRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        //         }
        //     }
        // }
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col]) {
                    g.setColor(Color.GRAY);
                    g.fillRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

    private void drawGameOver(Graphics g) {
        String gameOverText = "Game Over";
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics fontMetrics = g.getFontMetrics();
        int x = (getWidth() - fontMetrics.stringWidth(gameOverText)) / 2;
        int y = getHeight() / 2;
        g.drawString(gameOverText, x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawPiece(g);
        drawBoard(g);

        if (isGameOver) {
            drawGameOver(g);
        }
    }

    private class TetrisKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_DOWN:
                    movePieceDown();
                    break;
                case KeyEvent.VK_LEFT:
                    movePieceLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    movePieceRight();
                    break;
                case KeyEvent.VK_UP:
                    rotatePiece();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Tetris");
                Gui tetris = new Gui();
                frame.getContentPane().add(tetris);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
