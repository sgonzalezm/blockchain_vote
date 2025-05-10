package blockchain_vote;

import java.util.Scanner;

public class VotacionApp {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("ID Votante (o 'salir'): ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("salir")) break;

            System.out.print("Voto por (A/B/C): ");
            String candidato = sc.nextLine();

            blockchain.agregarVoto(id, candidato);
            System.out.println("✅ Voto registrado.");
        }

        System.out.println("\nValidando cadena...");
        if (blockchain.validarCadena())
            System.out.println("✅ Cadena válida.");
        else
            System.out.println("❌ Cadena alterada.");

        System.out.println("\nHistorial de votos:");
        blockchain.imprimirVotos();
    }
}
