import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private final int FRAME_WIDTH, FRAME_HEIGHT;
    private final double SCREEN_HEIGHT_RATIO = .8;
    private final double SCREEN_WIDTH_RATIO = .5;

    public MainFrame() {
        //Size frame based on screen size
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        FRAME_HEIGHT = (int)(screenDimensions.height * SCREEN_HEIGHT_RATIO);
        FRAME_WIDTH = (int)(screenDimensions.width * SCREEN_WIDTH_RATIO);
        //Initialize Frame
        this.setTitle("TIC-TAC-TOE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);

    }

    public int getFrameWidth() {
        return FRAME_WIDTH;
    }
    public int getFrameHeight() {
        return FRAME_HEIGHT;
    }

}

