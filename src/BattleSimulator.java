import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BattleSimulator {
    //
    JFrame aFrame, bFrame;
    JPanel playerPanel, oppPanel, bottomPanel, aPanel, bPanel, cPanel, dPanel;
    JButton attack, switchP, moveA, moveB, moveC, moveD;


    public BattleSimulator() {
        bFrame = new JFrame("Moves");
        bFrame.setLayout(new BoxLayout(bFrame.getContentPane(), BoxLayout.Y_AXIS));
        aFrame = new JFrame("Pokemon Battle Simulator");
        aFrame.setLayout(new BorderLayout());
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bottomPanel = new JPanel();
//        aFrame.add(playerPanel, BorderLayout.CENTER);
//        aFrame.add(oppPanel, BorderLayout.NORTH);
        aFrame.add(bottomPanel, BorderLayout.SOUTH);
        attack = new JButton("attack!");
        switchP = new JButton("switch");
        bottomPanel.add(attack);
        bottomPanel.add(switchP);
        moveA = new JButton("tackle");
        moveB = new JButton("protect");
        moveC = new JButton("ice shard");
        moveD = new JButton("swords dance");

        aPanel = new JPanel(new BorderLayout());
        bPanel = new JPanel(new BorderLayout());
        cPanel = new JPanel(new BorderLayout());
        dPanel = new JPanel(new BorderLayout());
        aPanel.add(moveA);
        bPanel.add(moveB);
        cPanel.add(moveC);
        dPanel.add(moveD);


        bFrame.add(aPanel);
        bFrame.add(bPanel);
        bFrame.add(cPanel);
        bFrame.add(dPanel);

        aFrame.setSize(450, 150);
        bFrame.setSize(450, 150);
        aFrame.setVisible(true);


        attack.addActionListener(this::actionPerformed);
    }
    public void actionPerformed(ActionEvent ae) {
        String buttonName = ae.getActionCommand();

        if (buttonName.equals("attack!")) {
            bFrame.setVisible(true);
        }
    }
    public static void main(String[] args) {
        BattleSimulator BS = new BattleSimulator();
    }

}
