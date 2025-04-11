package ma.SecureBankApp;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HMACSignature {
    public static void main(String[] args) throws Exception {
        String statement = "Solde du compte: 1234567.89 MAD au 11/04/2025";
        System.out.println("Donnée signée: " + statement);

        byte[] keyBytes = "secret-key-2025".getBytes(StandardCharsets.UTF_8);
        SecretKeySpec hmacKey = new SecretKeySpec(keyBytes, "HmacSHA256");

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(hmacKey);
        byte[] signature = mac.doFinal(statement.getBytes(StandardCharsets.UTF_8));
        String signatureBase64 = Base64.getEncoder().encodeToString(signature);
        System.out.println("Signature HMAC (Base64): " + signatureBase64);

        mac.init(hmacKey);
        byte[] newSignature = mac.doFinal(statement.getBytes(StandardCharsets.UTF_8));
        String newSignatureBase64 = Base64.getEncoder().encodeToString(newSignature);
        boolean isValid = signatureBase64.equals(newSignatureBase64);
        System.out.println("Résultat de la vérification: " + (isValid ? "Signature valide" : "Signature non valide"));
    }
}