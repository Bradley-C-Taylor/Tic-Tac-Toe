import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JButton implements ActionListener{

    private static char nextPiece = 'X';
    private boolean wasPressed = false;
    private char holding;

    public Square(int row, int col) {
        super();
        styleButton();
    }
    private void styleButton() {
        this.setFocusPainted(false);
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 150));
        this.setBackground(new Color(166,200,255));
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!wasPressed) {
            wasPressed = true;
            this.setText(getPiece());
        }
    }
    public String getPiece() {
        holding = nextPiece;
        if(nextPiece == 'X') {
            nextPiece = 'O';
        } else {
            nextPiece = 'X';
        }
        return String.valueOf(holding);
    }
    public char getHolding() {
        return this.holding;
    }
}
