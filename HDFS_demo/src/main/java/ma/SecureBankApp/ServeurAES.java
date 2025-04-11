package ma.SecureBankApp;

        import javax.crypto.Cipher;
        import javax.crypto.spec.SecretKeySpec;
        import java.nio.charset.StandardCharsets;
        import java.util.Base64;

        public class ServeurAES {
            public static void main(String[] args) throws Exception {
                String base64Key = "MDEyMzQ1Njc4OUFCQ0RFRkdISUpLTE1O";
                byte[] keyBytes = Base64.getDecoder().decode(base64Key);
                SecretKeySpec aesKey = new SecretKeySpec(keyBytes, "AES");

                String encryptedBase64 = "hpGEnPkQXAgYaCryNKltNgax4m5Zv3tL6ODpWh6WzuD5IqFKjoDid3bF2+66cPVpRODapmg48LLf5gEcP9ReWsHb3rg+fZXhFHnYZ+MFj4JkezU10BemHx7j/RoSTSqxkw5uLnm/OJLdu6+B7Gfqd2tl3V3olG94nJGMxb6C5GG3ql/dIsx74J90gQXH5VQ9EmRCtSklcKho0hOj+Wjdbm5UcQqBh+ssamktW3PvMDNg29NK0WFzEXpxJakvAVvE7052OkRNc4kWirI2s8+5aGv4g/9ww4v8E49TuFZu7lBymYBVpezxdZqOdeUnePUsCXskAxcVGCQCziykXStQow==";
                System.out.println("Message chiffré reçu (Base64): " + encryptedBase64);

                byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);

                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, aesKey);

                byte[] decrypted = cipher.doFinal(encryptedBytes);
                String decryptedMessage = new String(decrypted, StandardCharsets.UTF_8);
                System.out.println("Message déchiffré: " + decryptedMessage);
            }
        }