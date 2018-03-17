import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Player extends GameObject {
    private Handler handler;
    private int width = 50;
    private int height = 50;
    public Player (int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }
    public void tick() {
        this.x += this.velX;
        this.y += this.velY;

        // Stops the Player from going off the screen
        x = Game.clamp(x,0,Game.windowWidth-55);
        y = Game.clamp(y, 0, Game.windowHeight-90);

        //Checks for collision with Enemy and removes Enemy from Object list if that happens
        checkCollision();
    }

    public void checkCollision(){
        List<GameObject> list = new LinkedList<>();
        Iterator<GameObject> iterate = handler.objects.iterator();
        while(iterate.hasNext()){
            GameObject temp = iterate.next();
            if(temp.id == ID.Enemy){
                if (getBounds().intersects(temp.getBounds())){
                    list.add(temp);
                }
            }
        }

        for(GameObject object : list) {
            handler.removeObject(object);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x,y,width,height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }
}
