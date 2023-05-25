import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {
    private static final int NUM_ROWS = 30;
    private static final int NUM_COLS = 30;
    private static final int DELAY = 200;

    private int[][] board;
    private ArrayList<Point> snake;
    private Point food;
    private int direction;


    private Timer timer;

    public SnakeGame() {
        board = new int[NUM_ROWS][NUM_COLS];
        snake = new ArrayList<Point>();
        snake.add(new Point(NUM_ROWS / 2, NUM_COLS / 2));
        direction = -1;
        newFood();

        timer = new Timer(DELAY, this);
        timer.start();

        setPreferredSize(new Dimension(400, 400));
        setFocusable(true);
        addKeyListener(new SnakeKeyListener());
    }

    public void actionPerformed(ActionEvent e) {
        moveSnake();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = Math.min(getWidth() / NUM_COLS, getHeight() / NUM_ROWS);

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (board[i][j] == 0) {
                    g.setColor(Color.WHITE);
                } else if (board[i][j] == 1) {
                    g.setColor(Color.GREEN);
                } else if (board[i][j] == 2) {
                    g.setColor(Color.RED);
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    private void newFood() {
        int x = (int) (Math.random() * NUM_COLS);
        int y = (int) (Math.random() * NUM_ROWS);
        food = new Point(x, y);
        board[y][x] = 2;
    }

    private void moveSnake() {
        if (direction != -1) {
            Point head = snake.get(0);
            switch (direction) {
                case 0:
                    head = new Point(head.x, head.y - 1);
                    break;
                case 1:
                    head = new Point(head.x + 1, head.y);
                    break;
                case 2:
                    head = new Point(head.x, head.y + 1);
                    break;
                case 3:
                    head = new Point(head.x - 1, head.y);
                    break;
            }
            if (head.x < 0 || head.x >= NUM_COLS || head.y < 0 || head.y >= NUM_ROWS || board[head.y][head.x] == 1) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game over");
                System.exit(0);
            }
            snake.add(0, head);
            if (!head.equals(food)) {
                Point tail = snake.remove(snake.size() - 1);
                board[tail.y][tail.x] = 0;
            } else {
                newFood();
            }
            board[head.y][head.x] = 1;
        }
    }

    private class SnakeKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP && direction != 2) {
                direction = 0;
            } else if (keyCode == KeyEvent.VK_RIGHT && direction != 3) {
                direction = 1;
            } else if (keyCode == KeyEvent.VK_DOWN && direction != 0) {
                direction = 2;
            }else if(keyCode == KeyEvent.VK_LEFT && direction != 1) {
                direction = 3;
            }
            }
            }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        SnakeGame game = new SnakeGame();
        frame.getContentPane().add(game);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    }