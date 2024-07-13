package snake_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class gameBoard extends JPanel implements ActionListener {
    static final int unitSize = 40;
    static final int units = (snakeGame.width * snakeGame.height) / (unitSize * unitSize);
    static final int DELAY = 375;
    final int[] x = new int[units];
    final int[] y = new int[units];
    private int turnDirx;
    private int turnDiry;
    private int bodyParts = 3;
    private int applesEaten = 0;
    private int appleX;
    private int appleY;
    private char prevDirect = 'R';
    private char updDirect;
    private boolean running = false;


    ImageIcon apple = new ImageIcon(getClass().getResource("/Graphics/apple.png"));
    ImageIcon bodybottomleft = new ImageIcon(getClass().getResource("/Graphics/body_bottomleft.png"));
    ImageIcon bodybottomright = new ImageIcon(getClass().getResource("/Graphics/body_bottomright.png"));
    ImageIcon bodyhorizontal = new ImageIcon(getClass().getResource("/Graphics/body_horizontal.png"));
    ImageIcon bodytopleft = new ImageIcon(getClass().getResource("/Graphics/body_topleft.png"));
    ImageIcon bodytopright = new ImageIcon(getClass().getResource("/Graphics/body_topright.png"));
    ImageIcon bodyvertical = new ImageIcon(getClass().getResource("/Graphics/body_vertical.png"));
    ImageIcon headdown = new ImageIcon(getClass().getResource("/Graphics/head_down.png"));
    ImageIcon headleft = new ImageIcon(getClass().getResource("/Graphics/head_left.png"));
    ImageIcon headright = new ImageIcon(getClass().getResource("/Graphics/head_right.png"));
    ImageIcon headup = new ImageIcon(getClass().getResource("/Graphics/head_up.png"));
    ImageIcon taildown = new ImageIcon(getClass().getResource("/Graphics/tail_down.png"));
    ImageIcon tailleft = new ImageIcon(getClass().getResource("/Graphics/tail_left.png"));
    ImageIcon tailright = new ImageIcon(getClass().getResource("/Graphics/tail_right.png"));
    ImageIcon tailup = new ImageIcon(getClass().getResource("/Graphics/tail_up.png"));


    Timer timer;
    Random random;

    gameBoard() {
        random = new Random();
        timer = new Timer(DELAY, this);
        timer.start();
        this.setPreferredSize(new Dimension(snakeGame.width, snakeGame.height));
        this.setBackground(new Color(23, 23, 23));
        this.setFocusable(true);
        this.setLayout(new GridLayout(WIDTH * unitSize, snakeGame.height * unitSize));
        this.setBorder(BorderFactory.createLineBorder(new Color(38, 38, 38), 8));
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        prevDirect = updDirect;
                        updDirect = 'U';
                        break;
                    case KeyEvent.VK_DOWN:
                        prevDirect = updDirect;
                        updDirect = 'D';
                        break;
                    case KeyEvent.VK_LEFT:
                        prevDirect = updDirect;
                        updDirect = 'L';
                        break;
                    case KeyEvent.VK_RIGHT:
                        prevDirect = updDirect;
                        updDirect = 'R';
                        break;
                }
                running = true;
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (!running) {
            x[0] = 4 * unitSize;
            y[0] = 1 * unitSize;
            x[1] = x[0] - unitSize;     //3 * unitSize;
            y[1] = y[0];     //1 * unitSize;
            x[2] = x[1] - unitSize;     //2 * unitSize;
            y[2] = y[0];     //1 * unitSize;
            x[3] = x[2] - unitSize;     //1 * unitSize;
            y[3] = y[0];     //1 * unitSize;
        }

        switch (updDirect) {
            case 'R':
                if (prevDirect == 'U'){
                    turnDirx = x[0];
                    turnDiry = y[0];
                    headright.paintIcon(this, g, x[0], y[0]);
                    for (int i = 1; i < bodyParts ; i++) {
                        if (x[i] == turnDirx && y[i] == turnDiry) {
                            bodytopright.paintIcon(this, g, x[i], y[i]);
                        } else if (x[i] < turnDirx && y[i] < turnDiry) {
                            bodyvertical.paintIcon(this, g, x[i], y[i]);
                            tailup.paintIcon(this, g, x[i], y[i]);
                        }
                        bodyhorizontal.paintIcon(this, g, x[i], y[i]);
                    }
                    tailleft.paintIcon(this, g, x[bodyParts], y[bodyParts]);
                }
                else if (prevDirect == 'D'){
                    turnDirx = x[0];
                    turnDiry = y[0];
                    headright.paintIcon(this, g, x[0], y[0]);
                    for (int i = 1; i < bodyParts ; i++) {
                        if (x[i] == turnDirx && y[i] == turnDiry) {
                            bodybottomright.paintIcon(this, g, x[i], y[i]);
                        } else if (x[i] < turnDirx && y[i] > turnDiry) {
                            bodyvertical.paintIcon(this, g, x[i], y[i]);
                            taildown.paintIcon(this, g, x[i], y[i]);
                        }
                        bodyhorizontal.paintIcon(this, g, x[i], y[i]);
                    }
                    tailleft.paintIcon(this, g, x[bodyParts], y[bodyParts]);
                }else {
                    headright.paintIcon(this, g, x[0], y[0]);
                    for (int i = 1; i < bodyParts ; i++) {
                        bodyhorizontal.paintIcon(this, g, x[i], y[i]);
                    }
                    tailleft.paintIcon(this, g, x[bodyParts], y[bodyParts]);
                }
                break;

            case 'L':
                headleft.paintIcon(this, g, x[0], y[0]);
                for (int i = 1; i < bodyParts ; i++) {
                    bodyhorizontal.paintIcon(this, g, x[i], y[i]);
                }
                tailright.paintIcon(this, g, x[bodyParts], y[bodyParts]);
                break;
            case 'U':
                headup.paintIcon(this, g, x[0], y[0]);
                for (int i = 1; i < bodyParts ; i++) {
                    bodyvertical.paintIcon(this, g, x[i], y[i]);
                }
                taildown.paintIcon(this, g, x[bodyParts], y[bodyParts]);
                break;
            case 'D':
                headdown.paintIcon(this, g, x[0], y[0]);
                for (int i = 1; i < bodyParts ; i++) {
                    bodyvertical.paintIcon(this, g, x[i], y[i]);
                }
                tailup.paintIcon(this, g, x[bodyParts], y[bodyParts]);
                break;
        }
        g.dispose();

    }

    public void newApple() {
        appleX = random.nextInt((snakeGame.width / unitSize));
        appleY = random.nextInt((snakeGame.height / unitSize));
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (updDirect) {
            case 'R':
                x[0] = x[0] + unitSize;
                break;
            case 'L':
                x[0] = x[0] - unitSize;
                break;
            case 'U':
                y[0] = y[0] - unitSize;
                break;
            case 'D':
                y[0] = y[0] + unitSize;
                break;
        }

    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollision() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if (x[0] < 0) {
            running = false;
        }
        if (x[0] > snakeGame.width) {
            running = false;
        }
        if (y[0] < 0) {
            running = false;
        }
        if (y[0] > snakeGame.height) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            move();
            checkApple();
            checkCollision();
        }
        this.repaint();
    }
}
