package ma.mundiapolis;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PreSign {
    public static void main(String[] args) throws Exception {
        String message = "Mohamed Test";
        String secret = "1234567812345678";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), 0, secret.length(), "HmacSHA256");

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] signature = mac.doFinal(message.getBytes());
        String SignatureEncoded = Base64.getUrlEncoder().encodeToString(signature);
        System.out.println(SignatureEncoded);
    }
}
