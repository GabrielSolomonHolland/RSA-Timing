/*
Gabriel Solomon Holland
RSA Timing assignment
 */


package RSATiming;
import java.util.Scanner ;
import java.util.Random ;
/**
 * @author S535982
 */
public class Main {
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //scanner and random
        Scanner scan = new Scanner(System.in) ;
        Random rand = new Random() ;
        
        
        
        /**
        //Take user input for keys (Optional, if desired it randomly generates)
        System.out.println("Enter keysize or 0 to randomize (Keysize should be between 1024 and 4096): ");
        int keySize = scan.nextInt() ; //where program fails
        //int keySize = Integer.parseInt(keySizeStr) ; //work around for scan.nextInt() not working
        */
        int keySize = 2048 ;


        System.out.println("Enter key length or 0 to randomize (0<x<2,147,483,647): ");
        int keyLen = scan.nextInt() ;
        //int keyLen = Integer.parseInt(keyLenStr) ;

        

            
        
        //Implement random if they wanted that
        if(keySize == 0)
        {
            //keySize = rand.longs(long 1000000000000000, long 9999999999999999); //doesn't work for some reason
            keySize = rand.nextInt(4096);
        }
        
        if(keyLen == 0)
        {
            keyLen = rand.nextInt() ;
        }
        
        //Call method for RSA
        RSA_Methods.RSATiming(keySize, keyLen) ;
    
    
    
    
    
    
    
    }
    
    
  // Still attempting to make random work :/
  /**
  public static long rand (String[] args)
  {
    Random rand = new Random();
    long returnNum  = rand.nextLong();
    
    return returnNum ;
  }
  */
    
    
            /**
         * Pseudocode: 
         * timeRSA(keysize, strlen):
        generate keys using specified keysize
        generate a string of the specified strlen (contents don't matter, but generating a random string is a fun exercise)
        timemult = 1.0 / ITERS;
        encodeTime = 0.0
        decodeTime = 0.0
        for (int i=0; i<ITERS; i++)
        {
            start = System.nanoTime(); // using Java's timer here; you'd pick something else if you're using python/whatever
            encrypt = encryptMessage(plaintext, privateKey)
            end = System.nanoTime();
            encodeTime += (end-start) * timemult;
            start = System.nanoTime();
            decrypt = decryptMessage(encrypt, publicKey);
            end = System.nanoTime();
            decodeTime += (end-start) * timemult;
        }
        return encodeTime, decodeTime
         */
    
            //long returnNum  = rand.nextLong() ; //test this, getting rand to work was complicated
}
