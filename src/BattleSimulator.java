import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



public class BattleSimulator {
    private static final String USER_AGENT = "Mozilla/5.0";
    JFrame aFrame, bFrame;
    JPanel playerPanel, oppPanel, bottomPanel, aPanel, bPanel, cPanel, dPanel;
    JButton attack, switchP, moveA, moveB, moveC, moveD;
    JLabel playerHealth, oppHealth;
    JTextPane info;
    Pokemon poke1, poke2;
    String userTurn;
    String GET_URL;


    public BattleSimulator(Pokemon pokeA, Pokemon pokeB) {
        poke1 = pokeA;
        poke2 = pokeB;
        bFrame = new JFrame("Moves");
        bFrame.setLayout(new BoxLayout(bFrame.getContentPane(), BoxLayout.Y_AXIS));
        aFrame = new JFrame("Pokemon Battle Simulator");
        aFrame.setLayout(new BorderLayout());
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        playerPanel = new JPanel();
        oppPanel = new JPanel();
        playerHealth = new JLabel();
        playerHealth.setText(pokeA.getRemainHP() + "/" + pokeA.getTotHP());
        oppHealth = new JLabel();
        oppHealth.setText(pokeB.getRemainHP() + "/" + pokeB.getTotHP());
        playerPanel.add(playerHealth);
        oppPanel.add(oppHealth);
        info = new JTextPane();
        info.setText("battle start\n");



        aFrame.add(playerPanel, BorderLayout.SOUTH);
        aFrame.add(oppPanel, BorderLayout.NORTH);
        aFrame.add(info, BorderLayout.CENTER);
        aFrame.add(bottomPanel, BorderLayout.EAST);
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
                info.setText(info.getText() + poke1.getName() + " attacked " + poke2.getName() + " with " + move.getName() + "\n");

                poke1.damageCalc(poke2, move);
                if(!(poke1.isFainted() || poke2.isFainted())) {
                    info.setText(info.getText() + poke2.getName() + " attacked " + poke1.getName() + " with " + move2.getName()+ "\n");
                    poke2.damageCalc(poke1, move2);
                }
                else {
                    if(poke1.isFainted()) {
                        info.setText(info.getText() + poke1.getName() + " fainted \n");
                    }if(poke2.isFainted()) {
                        info.setText(info.getText() + poke2.getName() + " fainted \n");
                    }

                }

            }
            else{
                poke2.damageCalc(poke1, move2);
                if(!(poke1.isFainted()||poke2.isFainted())) {
                    poke1.damageCalc(poke2, move);
                }
                else {
                    if(poke1.isFainted()) {
                        info.setText(info.getText() + poke1.getName() + " fainted \n");
                    }if(poke2.isFainted()) {
                        info.setText(info.getText() + poke2.getName() + " fainted \n");
                    }

                }
            }




            System.out.println(poke2.toString());
            System.out.println(poke1.toString());
            oppHealth.setText(poke2.getRemainHP() + "/" + poke2.getTotHP());
            playerHealth.setText(poke1.getRemainHP() + "/" + poke2.getTotHP());

            if(poke1.isFainted()) {
                info.setText(info.getText() + poke1.getName() + " fainted \n" + poke2.getName() + " has won\n");
            }if(poke2.isFainted()) {
                info.setText(info.getText() + poke2.getName() + " fainted \n" + poke1.getName() + " has won\n");
            }
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
    private static void sendGET() throws IOException {
        URL obj = new URL("https://pokeapi.co/api/v2/move/8/");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            AttackingMoves moveList = gson.fromJson(response.toString(), AttackingMoves.class);
            System.out.println(moveList);

        } else {
            System.out.println("GET request did not work.");
        }
    }
    public static void main(String[] args) throws IOException{
        AttackingMoves tackle = new AttackingMoves("tackle","normal", 100, 40, true, false);
        AttackingMoves iceShard = new AttackingMoves("ice Shard","ice", 100, 40, true, 1);
        AttackingMoves bite = new AttackingMoves("bite","dark", 100, 60, true, false);
        AttackingMoves dazzlingGleam = new AttackingMoves("dazzling Gleam","fairy", 100, 80, false, false);
        AttackingMoves woodHammer = new AttackingMoves("Wood hammer","grass", 100, 120, true, true);
        Pokemon chesnaught = new Pokemon("Chesnaught", "grass", "fighting", "hardy", 88, 107, 122,74,75,64, tackle, woodHammer, tackle, tackle);
        Pokemon weavile = new Pokemon("weavile","ice","dark", "hardy", 70, 120, 65,45,85,125, tackle, iceShard, bite, dazzlingGleam);

        BattleSimulator BS = new BattleSimulator(weavile, chesnaught);
        BS.sendGET();
    }

}
