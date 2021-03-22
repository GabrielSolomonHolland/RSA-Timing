/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSATiming;
import java.util.Random ;
/**
 *
 * @author S535982
 */
public class RSA_Methods {
    public static long RSATiming(long keysize, int keyLen)
            {
                //Generate random string
                 byte[] array = new byte[keyLen]; // length is bounded by 7
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));
                return 4;
            }
}


/**
 * Pseudocode
 * generate keys using specified keysize
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
