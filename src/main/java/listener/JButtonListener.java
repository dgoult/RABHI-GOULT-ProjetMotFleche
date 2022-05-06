package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonListener implements ActionListener {

    public int x;
    public int y;

    public JButtonListener(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.printf(x + ":" + y + "\n");
    }
}
