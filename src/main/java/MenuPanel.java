import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final double MENU_PANE_RATIO = .1;

    public MenuPanel(int FRAME_WIDTH, int FRAME_HEIGHT) {
        super();
        this.setPreferredSize(new Dimension(FRAME_WIDTH, (int)(FRAME_HEIGHT * MENU_PANE_RATIO)));
        this.setBackground(Color.GRAY);
    }
}
