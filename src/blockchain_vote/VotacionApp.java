package blockchain_vote;

import java.util.Scanner;
import blockchain_vote.Blockchain;

public class VotacionApp {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VotacionUI(blockchain).setVisible(true);
        });
    }
}
