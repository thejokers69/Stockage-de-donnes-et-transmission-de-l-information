package ma.mundiapolis;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class VerifySign {
    public static void main(String[] args) throws Exception {
        String message = "Mohamed Test";
        String ReceivedSignEncoded = "FDu-0j_yJgzdLwFR7zWR7xMCIR1FG1j4QT1-YL0Lvm4=";
        String secret = "1234567812345678";
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), 0, secret.length(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] calculatedSignature = mac.doFinal(message.getBytes());
        String calculatedSignEncoded = Base64.getUrlEncoder().encodeToString(calculatedSignature);
        System.out.println(ReceivedSignEncoded.equals(calculatedSignEncoded) ? "OK" : "NOP");
    }
}
