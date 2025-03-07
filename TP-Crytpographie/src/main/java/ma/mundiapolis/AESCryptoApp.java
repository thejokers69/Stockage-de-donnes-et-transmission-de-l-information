package ma.mundiapolis;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESCryptoApp {
    public static void main(String[] args) throws Exception {
        String message="Bonjour tout le monde";
        String secret="1234567812345678";
        SecretKey secretkey = new SecretKeySpec(secret.getBytes(), 0,secret.length(),"AES");
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretkey);
        byte[] encryptedMessage=cipher.doFinal(message.getBytes());
        String encodedEncryptedMsg= Base64.getUrlEncoder().encodeToString(encryptedMessage);
        System.out.println(encodedEncryptedMsg);
    }

}
