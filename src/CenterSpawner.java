import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Kenan on 3/15/2018.
 */
public class CenterSpawner {
    private int width = 150;
    private int height = 150;
    private int x;
    private int y;
    private int score = 0;

    private Handler handler;

    public CenterSpawner(int x,int y,Handler handler){
        this.x = x;
        this.y = y;
        this.handler = handler;
    }

    public void tick() {
        score++;

        if(score/300 == 1) {
            int randomNumX = ThreadLocalRandom.current().nextInt(x-width/2, (x+width/2) - 24);
            int randomNumY = ThreadLocalRandom.current().nextInt(y-height/2, (y+height/2) - 24);
            score = 0;
            handler.addObject(new BasicEnemy(randomNumX, randomNumY, ID.Enemy));
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x-width/2,y-height/2,width,height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x-width/2,y-height/2,width,height);
    }
}
