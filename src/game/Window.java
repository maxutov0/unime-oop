// This class will define the window of the game
package game;
import javax.swing.*;


public class Window extends JFrame {

    public Window() {
        // Size of the game window
        int width = 300;
        int height = 600;

        // Configuration of the game window
        this.setSize(width, height);
        setTitle("Tetris Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    // Main method
    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);
    }   
    
}
