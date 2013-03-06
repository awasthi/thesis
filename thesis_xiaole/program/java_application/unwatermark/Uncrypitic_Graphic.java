/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xiaolefang
 */
import java.awt.image.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

public class Uncrypitic_Graphic {
    public int length = 0;
    
    private set_order s1 = new set_order();
    private set_order s2 = new set_order();
    
    
    private String keyname;
    private int keyname_index = 0;
    private chaos_property_mix cpm = new chaos_property_mix();
    public void set_up_ecrypt(String f)
    {
        keyname = f;
        keyname_index = 1;
    }
    public void set_off_ecrypt()
    {
        keyname = null;
        keyname_index = 0;
    }
    
    public int secret_key_length = 0;
    public int diff_en = 0;
    
    
    public char [] dencrypt(char [] c, String f)throws Exception
	{
		blowfish bf1 = new blowfish();
		bf1.setUp(f);
		byte[] encryptionBytes1 = null;
		
		
		encryptionBytes1 = new byte [c.length];
		for(int i =0; i<c.length;i++)
		{
			encryptionBytes1[i] = (byte)c[i];
		}
		String enter1 = bf1.decrypt(encryptionBytes1);
		c = new char [enter1.length()];
		for(int i=0; i<c.length; i++)
		{
			c[i] = enter1.charAt(i);
                }
                return c;
	}
    
    
    
    public void process(String image_file, String save_file) throws Exception
    {
        BufferedImage image = ImageIO.read(new File(image_file));
        int pixels_num = image.getHeight() * image.getWidth();
        s1.choose(1);
        s1.set_all_nums(16 * length);
        s1.set_ordered_nums(16 * length);
        s1.process();
        int [] bin_queue = s1.output();
        
        if(length*16 + secret_key_length * 32 > pixels_num )
        {
            diff_en = 0;
            return;
        }
        s2.choose(3);
        s2.set_all_nums(pixels_num);
        s2.set_ordered_nums(length * 16 + secret_key_length * 32);
        s2.process();
        int[] insert_queue = s2.output();
        
        int [] c_chaotic = new int[length * 16];
        for (int i = 0; i < c_chaotic.length; i++) {
            c_chaotic[i] = 0;
        }
        
        
        int [] bin = new int [length*16];
        WritableRaster raster = image.getRaster();
        int [] pixels = new int[pixels_num * 3];
        raster.getPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
        cpm.set_prng_index(1);
        for (int i = secret_key_length * 32; i < 16 * length + secret_key_length * 32; i++) {

            bin[bin_queue[i - secret_key_length * 32]] = (pixels[insert_queue[i]] & 1);
           // System.out.println(pixels[insert_queue[i]]);
            if (i != 0) {
                bin[bin_queue[i - secret_key_length * 32]] = bin[bin_queue[i - secret_key_length * 32]] ^ c_chaotic[bin_queue[i - secret_key_length * 32]];
            }
            cpm.init(c_chaotic);
            cpm.process();
            c_chaotic = cpm.output();

        }
        
        int tmp;
        char [] c = new char [length];
        for(int i = 0; i < length; i ++)
        {
            tmp = 0;
            for(int j = 0; j<16; j++)
            {
                tmp = tmp + (bin[i*16 + j]<<j);
            }
            c[i] = (char)tmp;
        }
        
        if(keyname_index == 1)
        {
            c = dencrypt( c, keyname);
        }
        
        
        
        
        try {
			FileWriter outFile = new FileWriter(save_file);
			PrintWriter out = new PrintWriter(outFile);
			for(int i =0; i < c.length;i++)
			{
				out.print(c[i]);
			}
			out.close();
                        diff_en = 1;
		} catch (IOException e) {
                    diff_en = 0;
		}
        
    }
}
