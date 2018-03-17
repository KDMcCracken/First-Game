import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Handler {
    LinkedList<GameObject> objects= new LinkedList<>();

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
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}
