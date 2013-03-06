import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.KeySpec;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;

public class blowfish {

	        private static String algorithm = "DESede";
	        private static Key key = null;
	        private static Cipher cipher = null;

	        public static void setUp(String f) throws Exception {
	        	
	            //key = KeyGenerator.getInstance(algorithm).generateKey();
	            //System.out.println(key.toString());
	        	String fl = f;
	            FileInputStream fis = new FileInputStream(fl);
	            int kl = fis.available();
	            byte[] kb = new byte[kl];
	            fis.read(kb);
	            fis.close();
	            KeySpec ks = null;
	            SecretKeyFactory kf = null;
	            
	            ks = new DESedeKeySpec(kb);
	            kf = SecretKeyFactory.getInstance(algorithm);
	            key = kf.generateSecret(ks);
	            cipher = Cipher.getInstance(algorithm);
	           //System.out.println(key.toString());
	            //System.out.println(cipher.getAlgorithm());
	        }


	        public static byte[] encrypt(String input)
	            throws InvalidKeyException, 
	                   BadPaddingException,
	                   IllegalBlockSizeException {
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] inputBytes = input.getBytes();
	            return cipher.doFinal(inputBytes);
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
