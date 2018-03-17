import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Kenan on 3/14/2018.
 */
public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(GameObject object : handler.objects){
            //Controls for Player
            if(object.getID() == ID.Player){
                if(key == KeyEvent.VK_UP){
                    object.setVelY(-5);
                }
                if(key == KeyEvent.VK_DOWN){
                    object.setVelY(5);
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    object.setVelX(-5);
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    object.setVelX(5);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        for(GameObject object : handler.objects){
            //Controls for Player
            if(object.getID() == ID.Player) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    object.setVelY(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    object.setVelY(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    object.setVelX(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    object.setVelX(0);
                }
            }
        }
    }
}
