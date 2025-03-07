package ma.mundiapolis;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDecryptoApp {
    public static void main(String[] args) throws Exception {
        String encodedCryptedMsg="1_Y-pHZIHAozaLEpdvzG3IlYshSosx6-tWJDwKJaqss=";
        byte []crypted= Base64.getUrlDecoder().decode(encodedCryptedMsg) ;
        String secret="1234567812345678";
        SecretKey secretkey = new SecretKeySpec(secret.getBytes(), 0,secret.length(),"AES");
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretkey);
        byte[] decryptedMessage=cipher.doFinal(crypted);
        System.out.println(new String(decryptedMessage));

    }

}
