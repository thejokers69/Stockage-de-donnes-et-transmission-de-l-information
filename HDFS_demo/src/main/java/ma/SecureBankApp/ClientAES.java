package ma.SecureBankApp;

        import javax.crypto.Cipher;
        import javax.crypto.spec.SecretKeySpec;
        import java.util.Base64;

        public class ClientAES {
            public static void main(String[] args) throws Exception {
                String base64Key = "MDEyMzQ1Njc4OUFCQ0RFRkdISUpLTE1O";
                byte[] keyBytes = Base64.getDecoder().decode(base64Key);
                SecretKeySpec aesKey = new SecretKeySpec(keyBytes, "AES");

                String message = "Virement 5000 MAD vers compte xxxxxxxxxxx du Mr Mohamed Lakssir";
                System.out.println("Message original: " + message);

                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);

                byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
                String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);
                System.out.println("Message chiffré (Base64): " + encryptedBase64);
            }
        }