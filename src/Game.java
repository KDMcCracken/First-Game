import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Kenan on 3/12/2018.
 */
public class Game extends Canvas implements Runnable{
    public static int windowWidth = 1000;
    public static int windowHeight = windowWidth /12 * 9;
    private Thread thread;
    private boolean running = false;

    /*
        Instantiate objects below this line
     */
    private Handler handler;
    private Menu menu;
    private HUD display;
    private static CenterSpawner spawner;

    public STATE gameState = STATE.Menu; //Sets original STATE as the menu

    public Game(){
        handler = new Handler();
        menu = new Menu(this,handler);
        this.addMouseListener(menu);
        new Window(windowWidth, windowHeight,"My first game", this);

        this.addKeyListener(new KeyInput(handler));

        display = new HUD();
        spawner = new CenterSpawner(windowWidth/2,windowHeight/2,handler);
    }

    public static void main(String args[]) {
        new Game();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0, windowWidth, windowHeight);

        handler.render(g);

        if(gameState == STATE.Menu){
            menu.render(g);
        }
        else if(gameState == STATE.Game){
            spawner.render(g);
            display.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        /*
            Clamps on object, ensuring it does not leave the window
         */
       if(var >= max){
            return max;
       }
       else if(var <= min){
           return min;
       }
       else{
           return var;
       }
    }

    private void tick(){
        handler.tick();
        if(gameState == STATE.Game) {
            display.tick();
            spawner.tick();
        }
    }

}
