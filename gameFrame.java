package Projects.snake_game;

import javax.swing.JFrame;

public class gameFrame extends JFrame {

    gameFrame(){
        gamePanel gPanel = new gamePanel();

        this.add(gPanel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
