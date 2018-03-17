import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kenan on 3/13/2018.
 */
public class Menu extends MouseAdapter {
    private int buttonWidth = 160;
    private int buttonHeight = 80;
    private int ButtonsXValue = Game.windowWidth/2 - (buttonWidth/2);
    private int buttonOneYValue = Game.windowHeight/2 - buttonHeight;
    private int buttonTwoYValue = Game.windowHeight/2 + buttonHeight;

    private Game game;
    private Handler handler;

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }

    public void render(Graphics g){
        g.setColor(Color.ORANGE);
        g.setFont(new Font("arial", Font.BOLD,20));
        int stringWidth = g.getFontMetrics().stringWidth("KENAN'S FIRST GAME");
        g.drawString("KENAN'S FIRST GAME", Game.windowWidth/2 - (stringWidth/2),Game.windowHeight/4);

        g.setColor(Color.orange);
        stringWidth = g.getFontMetrics().stringWidth("Start");
        int String1X = Game.windowWidth/2 - (buttonWidth/2) + (buttonWidth - stringWidth)/2;
        int String1Y = Game.windowHeight/2 - g.getFontMetrics().getAscent()*2;
        g.drawString("Start", String1X, String1Y);
        g.drawRect(ButtonsXValue, buttonOneYValue,buttonWidth,buttonHeight);

        g.setColor(Color.orange);
        stringWidth = g.getFontMetrics().stringWidth("Help");
        int String2X = Game.windowWidth/2 - (buttonWidth/2) + (buttonWidth - stringWidth)/2;
        int String2Y = Game.windowHeight/2 + (buttonHeight*2) - g.getFontMetrics().getAscent()*2;
        g.drawString("Help", String2X,String2Y);
        g.drawRect(ButtonsXValue,buttonTwoYValue,buttonWidth,buttonHeight);
    }
    public void tick(){

    }
    public void mousePressed(MouseEvent e){
        // User selected "Start" button
        if(checkMouseBounds(e.getX(),e.getY(),ButtonsXValue,buttonOneYValue)){
            game.gameState = STATE.Game;
            handler.addObject(new Player(100,100,ID.Player,handler));
            handler.addObject(new BasicEnemy(500,500,ID.Enemy));
        }
        //User selected "Help" button
        else if(checkMouseBounds(e.getX(),e.getY(),ButtonsXValue,buttonTwoYValue)) {
            game.gameState = STATE.Help;
        }
    }
    private boolean checkMouseBounds(int mX, int mY, int x, int y){
        if(mX > x && mX < x+buttonWidth){
            if(mY > y && mY < y+buttonHeight){
                return true;
            }
        }
        return false;
    }
}
