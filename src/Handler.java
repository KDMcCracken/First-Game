import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Handler {
    List<GameObject> objects = new CopyOnWriteArrayList<>();
    private final Object lockObject = new Object();

    public void tick(){
        //Ticks every objects 'tick' method
        for(GameObject object : objects){
            object.tick();
        }
    }

    public void render(Graphics g){
        //Renders all objects graphics
        for(GameObject object : objects){
            object.render(g);
        }
    }

    public void addObject(GameObject object){
        synchronized (this.lockObject) {
            this.objects.add(object);
        }
    }

    public void removeObject(GameObject object){
        synchronized (this.lockObject) {
            this.objects.remove(object);
        }
    }
}
