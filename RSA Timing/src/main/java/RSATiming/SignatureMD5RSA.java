import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class SignatureMD5RSA {
   public static void main(String[] args) throws Exception {
    
    //set up RSA key
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(1024);
    KeyPair keyPair = kpg.genKeyPair();

    //store data as array of bytes
    byte[] data = "test".getBytes("UTF8");
	
    //sign data
    Signature sig = Signature.getInstance("MD5WithRSA");
    sig.initSign(keyPair.getPrivate());
    sig.update(data);
    byte[] signatureBytes = sig.sign();

    String s = Base64.getEncoder().encodeToString(signatureBytes);
    System.out.println("Singature:" + s);
    System.out.println(s.length());
    
    //verify signature
    sig.initVerify(keyPair.getPublic());
    sig.update(data);

    System.out.println(sig.verify(signatureBytes));
  } 
}
