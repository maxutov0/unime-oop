import java.awt.Color;
import java.awt.Graphics;

public class GameOver extends Drawable {
    @Override
    void paint(Graphics g) {
        g.setColor(Color.white);

        for (int y = 0; y < Constants.GAME_OVER_MSG.length; y++) {
            for (int x = 0; x < Constants.GAME_OVER_MSG[y].length; x++) {
                if (Constants.GAME_OVER_MSG[y][x] == 1) {
                    g.fill3DRect(x*11+18, y*11+160, 10, 10, true);
                }
            }
        }
    }
}
