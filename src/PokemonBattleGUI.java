import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonBattleGUI extends JFrame {
    private JTextField pokemon1Field;
    private JTextField pokemon2Field;
    private JTextArea battleLogArea;
    private JButton customButton;

    public PokemonBattleGUI() {
        setTitle("Pokemon Battle Simulator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Pokemon 1:"));
        pokemon1Field = new JTextField();
        inputPanel.add(pokemon1Field);

        inputPanel.add(new JLabel("Pokemon 2:"));
        pokemon2Field = new JTextField();
        inputPanel.add(pokemon2Field);

        JButton battleButton = new JButton("Start Battle");
        battleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBattle();
            }
        });
        inputPanel.add(battleButton);

        customButton = new JButton("Custom");
        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customBattle();
            }
        });
        inputPanel.add(customButton);

        battleLogArea = new JTextArea();
        battleLogArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(battleLogArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void startBattle() {
        String pokemon1Name = pokemon1Field.getText().trim();
        String pokemon2Name = pokemon2Field.getText().trim();

        if (pokemon1Name.isEmpty() || pokemon2Name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Pokémon names", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Pokemon pokemon1 = new Pokemon(pokemon1Name);
            Pokemon pokemon2 = new Pokemon(pokemon2Name);

            BattleSimulator BS = new BattleSimulator(pokemon1, pokemon2);


        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching Pokémon data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void customBattle() {
        String pokemon1Name = JOptionPane.showInputDialog(this, "Enter name of Pokemon 1:");
        String pokemon2Name = JOptionPane.showInputDialog(this, "Enter name of Pokemon 2:");

        if (pokemon1Name == null || pokemon2Name == null || pokemon1Name.trim().isEmpty() || pokemon2Name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter valid Pokémon names", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Pokemon pokemon1 = new Pokemon(pokemon1Name.trim());
            Pokemon pokemon2 = new Pokemon(pokemon2Name.trim());

            BattleSimulator BS = new BattleSimulator(pokemon1, pokemon2);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching Pokémon data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PokemonBattleGUI gui = new PokemonBattleGUI();
            gui.setVisible(true);
        });
    }
}
