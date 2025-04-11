package ma.SecureBankApp;

        import javax.crypto.Cipher;
        import java.nio.charset.StandardCharsets;
        import java.security.KeyPair;
        import java.security.KeyPairGenerator;
        import java.util.Base64;

        public class RSAProtection {
            public static void main(String[] args) throws Exception {
                String cardNumber = "1234 5678 9012 3456";
                System.out.println("Donnée originale: " + cardNumber);

                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
                keyGen.initialize(2048);
                KeyPair keyPair = keyGen.generateKeyPair();

                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
                byte[] encrypted = cipher.doFinal(cardNumber.getBytes(StandardCharsets.UTF_8));
                String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);
                System.out.println("Donnée chiffrée (Base64): " + encryptedBase64);

                cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
                byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
                String decryptedData = new String(decrypted, StandardCharsets.UTF_8);
                System.out.println("Donnée déchiffrée: " + decryptedData);

                System.out.println("Vérification: " + (decryptedData.equals(cardNumber) ? "Succès" : "Échec"));
            }
        }