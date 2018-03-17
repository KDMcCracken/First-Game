import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenan on 3/12/2018.
 */
public class Window extends Canvas {
    public Window(int width, int height, String Title, Game game){
        JFrame frame = new JFrame(Title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
