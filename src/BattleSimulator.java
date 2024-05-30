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
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;



public class BattleSimulator {
    private static final String USER_AGENT = "Mozilla/5.0";
    JFrame aFrame, bFrame;
    JPanel playerPanel, oppPanel, bottomPanel, aPanel, bPanel, cPanel, dPanel;
    JButton attack, switchP, moveA, moveB, moveC, moveD;
    JLabel playerHealth, oppHealth;
    JTextPane info;
    Pokemon poke1, poke2;
    private JTextField pokemon1Field;
    private JTextField pokemon2Field;
    private JTextArea battleLogArea;
    private JButton customButton;


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
        playerHealth.setText(pokeA.getName() + ": " + pokeA.getRemainHP() + "/" + pokeA.getTotHP());
        oppHealth = new JLabel();
        oppHealth.setText(pokeB.getName() + ": " +pokeB.getRemainHP() + "/" + pokeB.getTotHP());
        playerPanel.add(playerHealth);
        oppPanel.add(oppHealth);
        info = new JTextPane();
        info.setText("battle start\n");



        aFrame.add(playerPanel, BorderLayout.SOUTH);
        aFrame.add(oppPanel, BorderLayout.NORTH);
        aFrame.add(info, BorderLayout.CENTER);
        aFrame.add(bottomPanel, BorderLayout.EAST);
        attack = new JButton("attack!");
        switchP = new JButton("custom");
        bottomPanel.add(attack);
        bottomPanel.add(switchP);
        moveA = new JButton(pokeA.getMove1());
        moveB = new JButton(pokeA.getMove2());
        moveC = new JButton(pokeA.getMove3());
        moveD = new JButton(pokeA.getMove4());

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

        aFrame.setSize(450, 800);
        bFrame.setSize(450, 150);
        aFrame.setVisible(true);


        for (JButton jButton : Arrays.asList(attack, moveA, moveB, moveC, moveD))
            jButton.addActionListener(ae -> {
                try {
                    actionPerformed(ae);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

    }
    public void playTurn(Moves move, Moves move2){

            if (poke1.isFainted() || poke2.isFainted()) {
                System.out.println("Battle end");
                return;
            }
            else {
                if(poke1.goFirst(poke2)){
                    info.setText(info.getText() + poke1.getName() + " attacked " + poke2.getName() + " with " + move.getName() + "\n");

                    info.setText(info.getText() + poke1.damageCalc(poke2, move) + "\n");
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
                    info.setText(info.getText() + poke1.damageCalc(poke1, move2) + "\n");
                    if(!(poke1.isFainted()||poke2.isFainted())) {
                        info.setText(info.getText() + poke1.damageCalc(poke2, move) + "\n");
                    }
                    else {
                        if(poke1.isFainted()) {
                            info.setText(info.getText() + poke1.getName() + " fainted \n");
                        }if(poke2.isFainted()) {
                            info.setText(info.getText() + poke2.getName() + " fainted \n");
                        }

                    }
                }





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
        if(buttonName.equals("custom")) {
            String pokemon1Name = JOptionPane.showInputDialog(this, "Enter name of Pokemon 1:");
            String pokemon2Name = JOptionPane.showInputDialog(this, "Enter name of Pokemon 2:");

            if (pokemon1Name == null || pokemon2Name == null || pokemon1Name.trim().isEmpty() || pokemon2Name.trim().isEmpty()) {
                System.out.println("no");
            }
        }

        if(buttonName.equalsIgnoreCase(poke1.getMove1())) {
            try {
                playTurn(Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke1.getMove1())), Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke2.getMove1())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove2())) {

            try {
                playTurn(Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke1.getMove2())), Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke2.getMove2())));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove3())) {

            try {
                playTurn(Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke1.getMove2())), Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke2.getMove2())));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(buttonName.equalsIgnoreCase(poke1.getMove4())) {

            try {
                playTurn(Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke1.getMove4())), Moves.fetchMoveDataFromAPI(PokeApi.moveAPI(poke2.getMove4())));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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


        } else {
            System.out.println("GET request did not work.");
        }
    }
    public static void main(String[] args) throws IOException{
//        AttackingMoves tackle = new AttackingMoves("tackle","normal", 100, 40, true, false);
//        AttackingMoves iceShard = new AttackingMoves("ice Shard","ice", 100, 40, true, 1);
//        AttackingMoves bite = new AttackingMoves("bite","dark", 100, 60, true, false);
//        AttackingMoves dazzlingGleam = new AttackingMoves("dazzling Gleam","fairy", 100, 80, false, false);
//        AttackingMoves woodHammer = new AttackingMoves("Wood hammer","grass", 100, 120, true, true);
//        Pokemon chesnaught = new Pokemon("Chesnaught", "grass", "fighting", "hardy", 88, 107, 122,74,75,64, tackle, woodHammer, tackle, tackle);
////        Pokemon weavile = new Pokemon("weavile","ice","dark", "hardy", 70, 120, 65,45,85,125, tackle, iceShard, bite, dazzlingGleam);
//
//        BattleSimulator BS = new BattleSimulator(weavile, chesnaught);
//        BS.sendGET();
    }

}
