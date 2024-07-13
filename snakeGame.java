
package snake_game;

import javax.swing.*;
import java.awt.*;

public class snakeGame{
    final static int width = 820;
    final static int height = 700;
    static JFrame frame = new JFrame("Snake Game");
    JLabel scorebord;

    snakeGame(){
        scorebord = new JLabel();
        scorebord.setPreferredSize(new Dimension(width,70));
        scorebord.setBackground(new Color( 28,28,28));
        scorebord.setForeground(Color.white);
        scorebord.setOpaque(true);
        scorebord.setHorizontalAlignment(SwingConstants.CENTER);
        scorebord.setFont(new Font("Arial",Font.BOLD,30));
        scorebord.setText("Snake Game");


        frame.setPreferredSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(scorebord,BorderLayout.NORTH);

        //frame.add(new gameFrame());
        //frame.pack();

        frame.add(new gameBoard());
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //gameFrame frame = new gameFrame();
        //frame.setVisible(true);
        new snakeGame();
    }
}