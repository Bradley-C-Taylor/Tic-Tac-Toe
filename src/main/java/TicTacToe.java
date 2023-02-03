import java.awt.*;
import java.util.*;
import java.util.List;

public class TicTacToe {

    private List<Square> board;

    public static void main(String[] args) {

        MainFrame ticTacToe = new MainFrame();
        GamePanel gamePanel = new GamePanel();
        MenuPanel menuPanel = new MenuPanel(ticTacToe.getFrameWidth(), ticTacToe.getFrameHeight());
        //Init Board of JButtons
        List<Square> board = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            Square newBox = new Square(i);
            board.add(newBox);
            gamePanel.add(newBox);
        }
        ticTacToe.add(menuPanel, BorderLayout.NORTH);
        ticTacToe.add(gamePanel, BorderLayout.CENTER);
        ticTacToe.setVisible(true);

        boolean gameOver = false;
        while(!gameOver) {
            //gameOver = this.checkForWin();
        }

    }

    public boolean checkForWin() {
        //any row, any column, either diagonal
        this.checkRow(0);
        return false;
    }
    public boolean checkRow(int rowNumber) {
        boolean foundWin = false;
        for(Square square: board);
        return foundWin;
    }

}
