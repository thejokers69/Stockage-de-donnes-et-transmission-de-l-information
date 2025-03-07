package ma.mundiapolis;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class CryptRSAAPP {
    public static void main(String[] args) throws Exception {
        String message= "Bonjour tout le monde";
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA") ;
        KeyPair keyPair=keyPairGenerator.generateKeyPair();
        PublicKey publickey= keyPair.getPublic();
        PrivateKey privateKey=keyPair.getPrivate();
//****** Chiffrement *******//
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publickey);
        byte[]cryptedMsg= cipher .doFinal (message. getBytes());
//**** déchiffrement *///
        cipher.init(Cipher .DECRYPT_MODE, privateKey);
        byte[] decryptedMS6=cipher.doFinal(cryptedMsg);
        System.out.println (new String (decryptedMS6));


    }
}

