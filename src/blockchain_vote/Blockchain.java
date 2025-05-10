package blockchain_vote;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    public List<Voto> cadena = new ArrayList<>();

    public void agregarVoto(String idVotante, String candidato) {
        String hashAnterior = cadena.isEmpty() ? "0" : cadena.get(cadena.size() - 1).hash;
        Voto nuevoVoto = new Voto(idVotante, candidato, hashAnterior);
        cadena.add(nuevoVoto);
    }

    public boolean validarCadena() {
        for (int i = 1; i < cadena.size(); i++) {
            Voto actual = cadena.get(i);
            Voto anterior = cadena.get(i - 1);

            if (!actual.hash.equals(actual.calcularHash()))
                return false;

            if (!actual.hashAnterior.equals(anterior.hash))
                return false;
        }
        return true;
    }

    public void imprimirVotos() {
        for (Voto voto : cadena) {
            System.out.println("Hash Voto: " + voto.hash);
            System.out.println("Candidato: " + voto.candidato);
            System.out.println("Hash Anterior: " + voto.hashAnterior);
            System.out.println("---");
        }
    }
}
