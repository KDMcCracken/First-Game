import java.awt.*;

/**
 * Created by Kenan on 3/15/2018.
 */
public class HUD{
    private int score = 0;

    public void tick() {
        score++;
    }

    public void render(Graphics g) {
        g.setFont(new Font("arial", Font.PLAIN,30));
        g.setColor(Color.orange);
        int stringWidth = g.getFontMetrics().stringWidth("Score");
        g.drawString("Score: " + score,Game.windowWidth/2 - stringWidth,50);
    }

    public Rectangle getBounds() {
        return null;
    }
}
