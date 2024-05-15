import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BattleSimulator {
    //
    JFrame aFrame, bFrame;
    JPanel playerPanel, oppPanel, bottomPanel, aPanel, bPanel, cPanel, dPanel;
    JButton attack, switchP, moveA, moveB, moveC, moveD;
    Pokemon poke1, poke2;


    public BattleSimulator(Pokemon pokeA, Pokemon pokeB) {
        poke1 = pokeA;
        poke2 = pokeB;
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
        moveA = new JButton(pokeA.getMove1().getName());
        moveB = new JButton(pokeA.getMove2().getName());
        moveC = new JButton(pokeA.getMove3().getName());
        moveD = new JButton(pokeA.getMove4().getName());

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
        moveA.addActionListener(this::actionPerformed);
        moveB.addActionListener(this::actionPerformed);
        moveC.addActionListener(this::actionPerformed);
        moveD.addActionListener(this::actionPerformed);

    }
    public void actionPerformed(ActionEvent ae) {
        String buttonName = ae.getActionCommand();

        if (buttonName.equals("attack!")) {
            bFrame.setVisible(true);
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove1().getName())) {

            poke1.damageCalc(poke2, poke1.getMove1());
            System.out.println(poke2.toString());
            poke2.damageCalc(poke1, poke1.getMove1());
            System.out.println(poke1.toString());
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove2().getName())) {

            poke1.damageCalc(poke2, poke1.getMove2());
            System.out.println(poke2.toString());
            poke2.damageCalc(poke1, poke1.getMove1());
            System.out.println(poke1.toString());

        }
        if(buttonName.equalsIgnoreCase(poke1.getMove3().getName())) {

            poke1.damageCalc(poke2, poke1.getMove3());
            System.out.println(poke2.toString());
            poke2.damageCalc(poke1, poke1.getMove1());
            System.out.println(poke1.toString());
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove4().getName())) {

            poke1.damageCalc(poke2, poke1.getMove4());
            System.out.println(poke2.toString());
            poke2.damageCalc(poke1, poke1.getMove1());
            System.out.println(poke1.toString());
        }

    }
    public static void main(String[] args) {
        AttackingMoves tackle = new AttackingMoves("tackle","normal", 1.00, 40, true);
        AttackingMoves iceShard = new AttackingMoves("ice Shard","ice", 1.00, 40, true, 1);
        AttackingMoves bite = new AttackingMoves("bite","dark", 1.00, 60, true);
        AttackingMoves dazzlingGleam = new AttackingMoves("dazzling Gleam","fairy", 1.00, 80, false);
        Pokemon chesnaught = new Pokemon("Chesnaught", "grass", "fighting", "hardy", 88, 107, 122,74,75,64);
        Pokemon weavile = new Pokemon("weavile","ice","dark", "hardy", 70, 120, 65,45,85,125, tackle, iceShard, bite, dazzlingGleam);

        BattleSimulator BS = new BattleSimulator(weavile, chesnaught);
    }

}
