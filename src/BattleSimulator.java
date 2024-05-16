import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BattleSimulator {
    //
    JFrame aFrame, bFrame;
    JPanel playerPanel, oppPanel, bottomPanel, aPanel, bPanel, cPanel, dPanel;
    JButton attack, switchP, moveA, moveB, moveC, moveD;
    JLabel playerHealth, oppHealth;
    Pokemon poke1, poke2;
    String userTurn;


    public BattleSimulator(Pokemon pokeA, Pokemon pokeB) {
        poke1 = pokeA;
        poke2 = pokeB;
        bFrame = new JFrame("Moves");
        bFrame.setLayout(new BoxLayout(bFrame.getContentPane(), BoxLayout.Y_AXIS));
        aFrame = new JFrame("Pokemon Battle Simulator");
        aFrame.setLayout(new BorderLayout());
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bottomPanel = new JPanel();
        playerPanel = new JPanel();
        oppPanel = new JPanel();
        playerHealth = new JLabel();
        playerHealth.setText(pokeA.getRemainHP() + "/" + pokeA.getTotHP());
        oppHealth = new JLabel();
        oppHealth.setText(pokeB.getRemainHP() + "/" + pokeB.getTotHP());
        playerPanel.add(playerHealth);
        oppPanel.add(oppHealth);



        aFrame.add(playerPanel, BorderLayout.CENTER);
        aFrame.add(oppPanel, BorderLayout.NORTH);
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
    public void playTurn(Moves move, Moves move2){
        if(poke1.isFainted() || poke2.isFainted()) {
            System.out.println("battle end");
        }
        else {
            if(poke1.goFirst(poke2)){
                poke1.damageCalc(poke2, move);
                if(!(poke1.isFainted() && poke2.isFainted())) {
                    poke2.damageCalc(poke1, move2);
                }

            }
            else{
                poke2.damageCalc(poke1, move2);
                if(!(poke1.isFainted() && poke2.isFainted())) {
                    poke1.damageCalc(poke2, move);
                }
            }




            System.out.println(poke2.toString());
            System.out.println(poke1.toString());
            oppHealth.setText(poke2.getRemainHP() + "/" + poke2.getTotHP());
            playerHealth.setText(poke1.getRemainHP() + "/" + poke2.getTotHP());
        }

    }
    public void actionPerformed(ActionEvent ae) {
        String buttonName = ae.getActionCommand();

        if (buttonName.equals("attack!")) {
            bFrame.setVisible(true);
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove1().getName())) {

            playTurn(poke1.getMove1(), poke2.getMove1());
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove2().getName())) {

            playTurn(poke1.getMove2(), poke2.getMove2());
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove3().getName())) {

            playTurn(poke1.getMove3(), poke2.getMove3());
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove4().getName())) {

            playTurn(poke1.getMove4(),poke2.getMove4());
        }

    }
    public static void main(String[] args) {
        AttackingMoves tackle = new AttackingMoves("tackle","normal", 1.00, 40, true, false);
        AttackingMoves iceShard = new AttackingMoves("ice Shard","ice", 1.00, 40, true, 1);
        AttackingMoves bite = new AttackingMoves("bite","dark", 1.00, 60, true, false);
        AttackingMoves dazzlingGleam = new AttackingMoves("dazzling Gleam","fairy", 1.00, 80, false, false);
        AttackingMoves woodHammer = new AttackingMoves("Wood hammer","grass", 1.00, 120, true, true);
        Pokemon chesnaught = new Pokemon("Chesnaught", "grass", "fighting", "hardy", 88, 107, 122,74,75,64, tackle, woodHammer, tackle, tackle);
        Pokemon weavile = new Pokemon("weavile","ice","dark", "hardy", 70, 120, 65,45,85,125, tackle, iceShard, bite, dazzlingGleam);

        BattleSimulator BS = new BattleSimulator(weavile, chesnaught);
    }

}
