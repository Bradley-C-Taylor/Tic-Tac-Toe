import javax.swing.*;
import java.awt.*;

public class ThreeInARow {

    private JFrame gameFrame;
    private Square[][] board;

    private char winner;
    private int BOARD_SIZE;
    private final int BUFFER = 10; //number of pixels between squares

    public static void main(String args[]) {
        ThreeInARow ticTacToe = new ThreeInARow();
        ticTacToe.run();
    }

    public void run() {
        try {
            String input = JOptionPane.showInputDialog(null,
                    "How many rows and columns would you like?\n(Maximum size is 6)");
            BOARD_SIZE = Integer.parseInt(input);
            if(BOARD_SIZE > 6) {
                throw new RuntimeException("Max board size is 6!");
            }
            initComponents();
            gameFrame.setVisible(true);
            //GAME LOOP
            boolean gameOver = false;
            while(!gameOver) {
                gameOver = hasWinner();
            }
            JOptionPane.showMessageDialog(null, winner + " is the winner!!!");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            System.exit(0);
        }
    }

    private boolean hasWinner() {
        //boolean hasWinner = false;
        for(int i = 0; i < board.length; i++) {
            if(rowHasWinner(i)) { return true; }
            if(colHasWinner(i)) { return true; }
        }
        return annoyingDiagonalHasWinner() || sameIndexDiagonalHasWinner();
    }
    private boolean annoyingDiagonalHasWinner() {
        int row = 0;
        int col = board[0].length - 1;
        winner = board[row][col].getHolding();
        while(row < board.length && col >= 0) {
            if(winner == 0 || board[row][col].getHolding() != winner) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    private boolean sameIndexDiagonalHasWinner() {
        winner = board[0][0].getHolding();
        for(int i = 0; i < board.length; i++) {
            if(winner == 0 || board[i][i].getHolding() != winner) {
                return false;
            }
        }
        return true;
    }
    private boolean rowHasWinner(int row) {
        winner = board[row][0].getHolding();
        for(int col = 0; col < board[row].length; col++) {
            if(winner == 0 || board[row][col].getHolding() != winner) {
                return false;
            }
        }
        return true;
    }
    private boolean colHasWinner(int col) {
        winner = board[0][col].getHolding();
        for(int row = 0; row < board.length; row++) {
            if(winner == 0 || board[row][col].getHolding() != winner) {
                return false;
            }
        }
        return true;
    }
    private void initComponents() {
        //Initialize screen dimension vars
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        double SCREEN_HEIGHT_RATIO = .8;
        int FRAME_HEIGHT = (int) (screenDimensions.height * SCREEN_HEIGHT_RATIO);
        double SCREEN_WIDTH_RATIO = .5;
        int FRAME_WIDTH = (int) (screenDimensions.width * SCREEN_WIDTH_RATIO);
        //Initialize Frame
        gameFrame = new JFrame("TIC-TAC-TOE");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        gameFrame.setLocationRelativeTo(null);
        //Initialize Panel
        JPanel gamePanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE, BUFFER, BUFFER));
        gamePanel.setBackground(Color.DARK_GRAY);
        gameFrame.add(gamePanel);
        //Initialize Buttons
        board = new Square[BOARD_SIZE][BOARD_SIZE];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square(row, col);
                gamePanel.add(board[row][col]);
            }
        }
    }
}
