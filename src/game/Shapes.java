package game;

import java.awt.Color;

public class Shapes {
    // Constants representing the different tetromino shapes
    public static final int SHAPE_I = 0;
    public static final int SHAPE_J = 1;
    public static final int SHAPE_L = 2;
    public static final int SHAPE_O = 3;
    public static final int SHAPE_S = 4;
    public static final int SHAPE_T = 5;
    public static final int SHAPE_Z = 6;

    // Array representing the shape of each tetromino
    private static final boolean[][][] TETROMINO_SHAPES = {
        // SHAPE_I
        {
            { false, false, false, false },
            { true, true, true, true },
            { false, false, false, false },
            { false, false, false, false }
        },
        // SHAPE_J
        {
            { true, false, false },
            { true, true, true },
            { false, false, false }
        },
        // SHAPE_L
        {
            { false, false, true },
            { true, true, true },
            { false, false, false }
        },
        // SHAPE_O
        {
            { true, true },
            { true, true }
        },
        // SHAPE_S
        {
            { false, true, true },
            { true, true, false },
            { false, false, false }
        },
        // SHAPE_T
        {
            { false, true, false },
            { true, true, true },
            { false, false, false }
        },
        // SHAPE_Z
        {
            { true, true, false },
            { false, true, true },
            { false, false, false }
        }
    };

    // Array representing the colors of each tetromino shape
    private static final Color[] TETROMINO_COLORS = {
        Color.CYAN,     // SHAPE_I
        Color.BLUE,     // SHAPE_J
        Color.ORANGE,   // SHAPE_L
        Color.YELLOW,   // SHAPE_O
        Color.GREEN,    // SHAPE_S
        Color.MAGENTA,  // SHAPE_T
        Color.RED       // SHAPE_Z
    };

    // Instance variables
    private int shape;
    private boolean[][] currentShape;
    private Color color;

    // Constructor
    public Shapes(int shape) {
        this.shape = shape;
        this.currentShape = TETROMINO_SHAPES[shape];
        this.color = TETROMINO_COLORS[shape];
    }

    // Getter methods
    public int getShape() {
        return shape;
    }

    public boolean[][] getCurrentShape() {
        return currentShape;
    }

    public Color getColor() {
        return color;
    }
}
