import javax.swing.*;
import java.awt.*;

public class battleSimulator {
    //
    JFrame aFrame, bFrame;
    JPanel playerPanel, oppPanel;
    JButton attack, switchP;

    public battleSimulator() {
        aFrame = new JFrame("Pokemon Battle Simulator");
        aFrame.setLayout(new BorderLayout());
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);







        aFrame.pack();
        aFrame.setVisible(true);
    }
    public static void main(String[] args) {

    }

}
