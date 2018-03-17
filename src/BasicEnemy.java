import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Kenan on 3/15/2018.
 */
public class BasicEnemy extends GameObject {
    private int width = 25;
    private int height = 25;

    public BasicEnemy(int x, int y, ID id){
        super(x,y,id);
        // Generates a random speed and direction
        velX = ThreadLocalRandom.current().nextInt(-5,5);
        velY = ThreadLocalRandom.current().nextInt(-5,5);
    }
    public void tick() {
        x += velX;
        y += velY;
        // Reverses X direction upon impact with left or right side of screen
        if(x <= 0 || x >= Game.windowWidth - width){
            velX *= -1;
        }
        // Reverses Y direction upon impact with left or right side of screen
        if(y <= 0 || y >= Game.windowHeight - height*2){
            velY *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x,y,width,height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }
}
