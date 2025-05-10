package blockchain_vote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VotacionUI extends JFrame {
    private JTextField txtVotante;
    private JComboBox<String> candidatos;
    private JTextArea outputArea;
    private Blockchain blockchain;

    public VotacionUI(Blockchain blockchain) {
        this.blockchain = blockchain;
        setTitle("Sistema de Votación Blockchain");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        topPanel.add(new JLabel("ID del Votante:"));
        txtVotante = new JTextField();
        topPanel.add(txtVotante);

        topPanel.add(new JLabel("Elige tu candidato:"));
        candidatos = new JComboBox<>(new String[]{"A", "B", "C"});
        topPanel.add(candidatos);

        JButton votarBtn = new JButton("Votar");
        topPanel.add(votarBtn);

        JButton validarBtn = new JButton("Validar Cadena");
        topPanel.add(validarBtn);

        add(topPanel, BorderLayout.NORTH);

        // Área de salida
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Acciones
        votarBtn.addActionListener(e -> registrarVoto());
        validarBtn.addActionListener(e -> validarCadena());
    }

    private void registrarVoto() {
        String id = txtVotante.getText().trim();
        String candidato = (String) candidatos.getSelectedItem();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese su ID de votante");
            return;
        }

        blockchain.agregarVoto(id, candidato);
        outputArea.append("✅ Voto registrado para el candidato " + candidato + "\n");
        txtVotante.setText("");
    }

    private void validarCadena() {
        boolean esValida = blockchain.validarCadena();
        outputArea.append(esValida ? "✅ Cadena válida\n" : "❌ Cadena alterada\n");
    }
}
