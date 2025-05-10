package blockchain_vote;
import java.security.MessageDigest;
import java.time.LocalDateTime;

public class Voto {
    public String idVotanteHash;
    public String candidato;
    public String timestamp;
    public String hashAnterior;
    public String hash;

    public Voto(String idVotante, String candidato, String hashAnterior) {
        this.idVotanteHash = sha256(idVotante);
        this.candidato = candidato;
        this.timestamp = LocalDateTime.now().toString();
        this.hashAnterior = hashAnterior;
        this.hash = calcularHash();
    }

    public String calcularHash() {
        String datos = idVotanteHash + candidato + timestamp + hashAnterior;
        return sha256(datos);
    }

    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes)
                sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
