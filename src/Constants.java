public final class Constants {
    // constants for program
    public static final String TITLE_OF_PROGRAM = "Tetris";
    public static final int BLOCK_SIZE = 25; // size of one block
    public static final int ARC_RADIUS = 5;
    public static final int FIELD_WIDTH = 10; // size game field in block
    public static final int FIELD_HEIGHT = 18;
    public static final int START_LOCATION = 180;
    public static final int FIELD_DX = 7; // determined experimentally
    public static final int FIELD_DY = 26;
    public static final int LEFT = 37; // key codes
    public static final int UP = 38;
    public static final int RIGHT = 39;
    public static final int DOWN = 40;
    public static final int SHOW_DELAY = 400; // delay for animation
    
    public static final int[] SCORES = {100, 300, 700, 1500}; // scores for 1/2/3/4 lines
    public static final int[][] mine = new int[FIELD_HEIGHT + 1][FIELD_WIDTH]; // mine/glass

    public static final int[][] GAME_OVER_MSG = {
        {0,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0,1,1,0},
        {1,0,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,1},
        {1,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1},
        {1,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0},
        {0,1,1,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0},
        {1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0},
        {1,0,0,1,0,1,0,1,0,0,1,1,1,1,0,1,1,1,0,0},
        {1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,0,1,0},
        {0,1,1,0,0,1,0,0,0,0,0,1,1,0,0,1,0,0,1,0}
    }; 

    public static final int[][][] SHAPES = {
        {{0,0,0,0}, {1,1,1,1}, {0,0,0,0}, {0,0,0,0}, {4, 0x00f0f0}}, // I
        {{0,0,0,0}, {0,1,1,0}, {0,1,1,0}, {0,0,0,0}, {4, 0xf0f000}}, // O
        {{1,0,0,0}, {1,1,1,0}, {0,0,0,0}, {0,0,0,0}, {3, 0x0000f0}}, // J
        {{0,0,1,0}, {1,1,1,0}, {0,0,0,0}, {0,0,0,0}, {3, 0xf0a000}}, // L
        {{0,1,1,0}, {1,1,0,0}, {0,0,0,0}, {0,0,0,0}, {3, 0x00f000}}, // S
        {{1,1,1,0}, {0,1,0,0}, {0,0,0,0}, {0,0,0,0}, {3, 0xa000f0}}, // T
        {{1,1,0,0}, {0,1,1,0}, {0,0,0,0}, {0,0,0,0}, {3, 0xf00000}}  // Z
    };
}