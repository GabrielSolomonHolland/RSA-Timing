import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
 
import javax.crypto.Cipher;
 
// Java example for RSA encryption/decryption.
// Uses strong encryption with 2048 key size.
public class RSATestApp {
 
    public static void main(String[] args) throws Exception {
        String plainText = "Insert a test string here, this will be it for now";
 
        // Generate public and private keys
        Map<String, Object> keys = getRSAKeys();
 
        PrivateKey privateKey = (PrivateKey) keys.get("private");
        PublicKey publicKey = (PublicKey) keys.get("public");
 
        String encryptedText = encryptMessage(plainText, privateKey);
        String descryptedText = decryptMessage(encryptedText, publicKey);
 
        System.out.println("input:" + plainText);
        System.out.println("encrypted:" + encryptedText);
        System.out.println("decrypted:" + descryptedText);
        
        
        int iters = 50 ;
        double timemult = 1.0/iters;
        double encodeTime = 0.0 ;
        double decodeTime = 0.0 ;
        
        for (int i=0; i<iters; i++)
            {
            float start = System.nanoTime(); // using Java's timer
            String encrypted = encryptMessage(plainText, privateKey);
            float end = System.nanoTime();
            encodeTime += (end-start) * timemult;
            start = System.nanoTime();
            String decrypt = decryptMessage(encrypted, publicKey);
            end = System.nanoTime();
            decodeTime += (end-start) * timemult;
            }
        System.out.println("Encode time: " + encodeTime + "\n Decode time: " + decodeTime);
 
    // Get RSA keys. Key size 2048 bits.
    }

    public static Map<String,Object> getRSAKeys() throws Exception
    {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
 
        Map<String, Object> keys = new HashMap<String,Object>();
        keys.put("private", privateKey);
        keys.put("public", publicKey);
        return keys;
    }
 
    public static String decryptMessage(String encryptedText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }
 
    public static String encryptMessage(String plainText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }
 
}