import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;

import javax.crypto.*;

public class blowfish {

	        private static String algorithm = "DESede";
	        private static Key key = null;
	        private static Cipher cipher = null;

	        public static void setUp(String f) throws Exception {
	        //	KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
	          //  keyGenerator.init(32);
	            key = KeyGenerator.getInstance(algorithm).generateKey();
	            //System.out.println(key.toString());
	            
	            String fl = f;
	            FileOutputStream fos = new FileOutputStream(fl);
	            byte[] kb = key.getEncoded();
	            fos.write(kb);
	            fos.close();
	            
	           // key = keyGenerator.generateKey();
	            //System.out.println(key.toString());
	            cipher = Cipher.getInstance(algorithm);
	           // System.out.println(key.getAlgorithm());
	           // System.out.println(cipher.getAlgorithm());
	            //System.out.println(cipher.getBlockSize());
	        
	        }


	        public static byte[] encrypt(String input)
	            throws InvalidKeyException, 
	                   BadPaddingException,
	                   IllegalBlockSizeException {
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] inputBytes = input.getBytes();
	            byte[] encryptionBytes1 = cipher.doFinal(inputBytes);
	            return encryptionBytes1;//cipher.doFinal(inputBytes);
	        }

	        public static String decrypt(byte[] encryptionBytes)
	            throws InvalidKeyException, 
	                   BadPaddingException,
	                   IllegalBlockSizeException {
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            byte[] recoveredBytes = 
	              cipher.doFinal(encryptionBytes);
	            String recovered = 
	              new String(recoveredBytes);
	            return recovered;
	          }

}
