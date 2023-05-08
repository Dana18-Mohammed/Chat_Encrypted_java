/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

    
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class BlowfishCTR {
    private static final String ALGORITHM = "Blowfish";
    private static final String MODE = "CTR";
    private static final String PADDING = "NoPadding";
/** Minimum key length in bits. */
  public static final int MIN_KEY_LENGTH = 32;

  /** Maximum key length in bits. */
  public static final int MAX_KEY_LENGTH = 448;

  /** Available key lengths in bits. */
  public static final int[] KEY_LENGTHS = new int[] {448, 384, 320, 256, 192,128,  64, };
    /** Number of bits in byte. */
  private static final int BITS_IN_BYTE = 8;
    public static void main(String[] args) throws Exception {
        // Generate the key
        // generate subkeys.
       SecretKey secretKey = new SecretKeySpec("my-secret-key".getBytes(), ALGORITHM);

        // Initialize the cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM + "/" + MODE + "/" + PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new SecureRandom());
        byte[] iv = cipher.getIV();

        // Encrypt the message
        byte[] plaintext = "Hello, world!".getBytes();
        byte[] ciphertext = cipher.doFinal(plaintext);

        // Decrypt the message
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decrypted = cipher.doFinal(ciphertext);

        System.out.println(new String(ciphertext));
    }
}