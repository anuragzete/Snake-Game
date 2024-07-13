package snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameFrame extends JPanel {
    public static boolean isClassic;
    public static boolean isEasy;
    private int btn1Count = 0;
    private int btn2Count = 0;
    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    Container buttonHolder = new Container();
    JLabel label = new JLabel();
    GridBagConstraints gbc = new GridBagConstraints();

    gameFrame() {
        this.setPreferredSize(new Dimension((snakeGame.width - 50), (snakeGame.height - 150)));
        this.setBackground(new Color(23,23,23));
        this.setLayout(new BorderLayout());

        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setPreferredSize(new Dimension(snakeGame.width, 150));
        label.setText("Select the mode");
        label.setHorizontalAlignment(SwingConstants.CENTER);


        btn1.setBackground(new Color(32,32,32));
        btn2.setBackground(new Color(32,32,32));
        btn1.setPreferredSize(new Dimension(150,100));
        btn2.setPreferredSize(new Dimension(150,100));
        btn1.setFont(new Font("Arial", Font.BOLD, 30));
        btn2.setFont(new Font("Arial", Font.BOLD, 30));
        btn1.setForeground(Color.white);
        btn2.setForeground(Color.white);
        btn1.setText("Classic");
        btn2.setText("Infinite");

        buttonHolder.setBackground(new Color(26,26,26));
        buttonHolder.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        buttonHolder.add(btn1, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 70, 0);
        buttonHolder.add(btn2, gbc);

        this.add(label, BorderLayout.NORTH);
        this.add(buttonHolder, BorderLayout.CENTER);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn1Count == 0) {
                    isClassic = true;
                    label.setText("Select difficulty level");
                    btn1.setText("Easy");
                    btn2.setText("Hard");
                    btn1Count++;
                } else if (btn1Count == 1) {
                    isEasy = true;
                    snakeGame.frame.setContentPane(new gamePanel());
                    snakeGame.frame.validate();
                    snakeGame.frame.repaint();

                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn1Count == 0) {
                    isClassic = false;
                    label.setText("Select difficulty level");
                    btn1.setText("Easy");
                    btn2.setText("Hard");
                    btn1Count++;
                } else if (btn1Count == 1) {
                    isEasy = false;
                }
            }
        });
    }
}
