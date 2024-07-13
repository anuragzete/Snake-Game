/*package snake_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class gamePanel extends Container{

    static final int boardWidth = snakeGame.width - 20;
    static final int boardHeight = snakeGame.height - 20;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (boardWidth * boardHeight) / UNIT_SIZE;
    static final int DELAY = 75;

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    int bodyParts = 6;
    int applesEatten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;

    Timer timer;
    Random random;

    JPanel panel = new JPanel();

    gamePanel(){
        random = new Random();
        panel.setPreferredSize(new Dimension(boardWidth, boardHeight));
        panel.setBackground(Color.black);
        panel.setFocusable(true);
        panel.addKeyListener(new myKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, (ActionListener) panel);
        timer.start();
    }

    public void paintComponent(Graphics g){
        panel.repaint();
        draw(g);
    }

    public void draw(Graphics g){
        if (running){
            for (int i = 0; i < boardHeight /UNIT_SIZE; i++){
                g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE, boardHeight);
                g.drawLine(0,i*UNIT_SIZE, boardWidth,i*UNIT_SIZE);
            }

            g.setColor(Color.red);
            g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0){
                    g.setColor(Color.green);
                    g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(45,100,0));
                    g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
                }
            }
        }
        else {
            gameOver(g);
        }
    }

    public void newApple(){
        appleX = random.nextInt((int) (boardWidth /UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int) (boardHeight /UNIT_SIZE))*UNIT_SIZE;
    }

    public void move(){
        for (int i = bodyParts;i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direction){
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple(){
        if ((x[0] == appleX) && (y[0] == appleY)){
            bodyParts++;
            applesEatten++;
            newApple();
        }
    }

    public void checkCollision(){
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if (x[0] < 0){
            running = false;
        }
        if (x[0] > boardWidth){
            running = false;
        }
        if (y[0] < 0){
            running = false;
        }
        if (y[0] > boardHeight){
            running = false;
        }

        if (!running){
            timer.stop();
        }
    }

    public void gameOver(Graphics g){

    }

    public void actionPerformed(ActionEvent e){
        if (running){
            move();
            checkApple();
            checkCollision();
        }
        panel.repaint();
    }

    public class myKeyAdapter extends KeyAdapter{
        //@Override
        public void KeyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
            }
        }
    }
}*/

/*

package snake_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class gamePanel extends JPanel implements ActionListener{

    static final int boardWidth = snakeGame.width - 20;
    static final int boardHeight = snakeGame.height - 20;
    static final int unitSize = 50;
    static final int units = (boardWidth*boardHeight)/(unitSize*unitSize);
    static final int DELAY = 175;
    final int x[] = new int[units];
    final int y[] = new int[units];
    private int bodyParts = 5;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'R';
    private boolean running = false;

    Timer timer;
    Random random;

    gamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(boardWidth,boardHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
			for(int i=0;i<boardHeight/unitSize;i++) {
				g.drawLine(i*unitSize, 0, i*unitSize, boardHeight);
				g.drawLine(0, i*unitSize, boardWidth, i*unitSize);
			}


            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitSize, unitSize);

            for(int i = 0; i< bodyParts;i++) {
                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
            }
            g.setColor(Color.red);
            g.setFont( new Font("Ink Free",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+applesEaten, (boardWidth - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }
    public void newApple(){
        appleX = random.nextInt((boardWidth/unitSize))*unitSize;
        appleY = random.nextInt((boardHeight/unitSize))*unitSize;
    }
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - unitSize;
                break;
            case 'D':
                y[0] = y[0] + unitSize;
                break;
            case 'L':
                x[0] = x[0] - unitSize;
                break;
            case 'R':
                x[0] = x[0] + unitSize;
                break;
        }

    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if(x[0] > boardWidth) {
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > boardHeight) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (boardWidth - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 60));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (boardWidth - metrics2.stringWidth("Game Over"))/2, boardHeight/2);
        g.setColor(Color.gray);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        g.drawString("Press Enter to continue and Esc to exit", (boardWidth - metrics2.stringWidth("Press Enter to continue and Esc to exit"))/2, boardHeight/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}

*/



package snake_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class gamePanel extends JPanel {

    static final int boardWidth = snakeGame.width - 20;
    static final int boardHeight = snakeGame.height - 20;
    static final int unitSize = 50;
    static final int units = (boardWidth*boardHeight)/(unitSize*unitSize);
    static final int DELAY = 175;
    final int x[] = new int[units];
    final int y[] = new int[units];
    private int bodyParts = 5;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'R';
    private boolean running = false;

    Timer timer;
    Random random;

    gamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(boardWidth,boardHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (running){
                    switch(e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if(direction != 'R') {
                                direction = 'L';
                                updateBord();
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if(direction != 'L') {
                                direction = 'R';
                                updateBord();
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if(direction != 'D') {
                                direction = 'U';
                                updateBord();
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if(direction != 'U') {
                                direction = 'D';
                                updateBord();
                            }
                            break;
                    }
                }
                else {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        direction = 'L';
                        break;
                    case KeyEvent.VK_RIGHT:
                        direction = 'R';
                        break;
                    case KeyEvent.VK_UP:
                        direction = 'U';
                        break;
                    case KeyEvent.VK_DOWN:
                        direction = 'D';
                        break;
                }
                startGame();
                }
            }

        });



    }
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY,(ActionListener) this);
        timer.start();
    }
    public void updateBord() {

        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
            for(int i=0;i<boardHeight/unitSize;i++) {
                g.drawLine(i*unitSize, 0, i*unitSize, boardHeight);
                g.drawLine(0, i*unitSize, boardWidth, i*unitSize);
            }


            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitSize, unitSize);

            for(int i = 0; i< bodyParts;i++) {
                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
            }
            g.setColor(Color.red);
            g.setFont( new Font("Ink Free",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+applesEaten, (boardWidth - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }
    public void newApple(){
        appleX = random.nextInt((boardWidth/unitSize))*unitSize;
        appleY = random.nextInt((boardHeight/unitSize))*unitSize;
    }
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - unitSize;
                break;
            case 'D':
                y[0] = y[0] + unitSize;
                break;
            case 'L':
                x[0] = x[0] - unitSize;
                break;
            case 'R':
                x[0] = x[0] + unitSize;
                break;
        }

    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if(x[0] > boardWidth) {
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > boardHeight) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {
        //Score
        /*g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (boardWidth - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 60));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (boardWidth - metrics2.stringWidth("Game Over"))/2, boardHeight/2);
        g.setColor(Color.gray);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        g.drawString("Press Enter to continue and Esc to exit", (boardWidth - metrics2.stringWidth("Press Enter to continue and Esc to exit"))/2, boardHeight/2);*/

    }



}
