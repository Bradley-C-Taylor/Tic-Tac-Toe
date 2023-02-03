import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO: add state variable: edit appearance: add action listener
public class Square extends JButton implements ActionListener{

    private static String nextPiece = "X";
    private boolean wasPressed = false;
    private boolean isX = false, isO = false;
    private int row;
    private int column;

    public Square(int index) {
        super();
        styleButton();
        setRow(index);
        setColumn(index);
    }

    private void styleButton() {
        this.setFocusPainted(false);
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 150));
        this.setBackground(new Color(166,200,255));
        this.addActionListener(this::actionPerformed);
    }

    public void setRow(int index) {
        if(index < 3) {
            row = 0;
        } else if(index < 6) {
            row = 1;
        } else {
            row = 2;
        }
    }
    public void setColumn(int index) {
        if(index % 3 == 0) {
            column = 0;
        } else if(index % 3 == 1) {
            column = 1;
        } else {
            column = 2;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(wasPressed) {
            return;
        } else {
            wasPressed = true;
            System.out.println("Row: " + this.row + "\tColumn: " + this.column);
            this.setText(getPiece());
        }
    }

    public String getPiece() {
        String currentPiece = nextPiece;
        if(nextPiece.equals("X")) {
            isX = true;
            nextPiece = "O";
        } else {
            isO = true;
            nextPiece = "X";
        }
        return currentPiece;
    }
}
