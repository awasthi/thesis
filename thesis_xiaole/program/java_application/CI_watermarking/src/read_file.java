import java.io.*;

public class read_file {
	private String file;
	private char [] c;
	private int [] bin;
	private int c_length;
	private int bin_length;
    int file_error = 1;
	public void init(String name)
	{
		file = name;
	}
	
	public void read_c()
	{
		File f1 = new File (file);
		BufferedReader reader = null;
		String s;
		int tmp1 = 0;
		int tmp2 = 0;
		c_length = 0;
		try
		{
			
			reader = new BufferedReader(new FileReader(f1));
			c_length = (int)f1.length();
			c = new char [(int)f1.length()];
			while((s = reader.readLine())!=null)
			{
				tmp1 = s.length() + tmp1;
				for(int i=tmp2;i<(tmp1);i++)
				{
					
					c[i] = s.charAt(i-tmp2);
				}
				
				if(tmp1<c_length)
				c[tmp1] = '\n';
				
				tmp1 ++;
				tmp2 = tmp1;
			}
			
			file_error = 0;
		}catch(IOException e){
			e.printStackTrace();
		}finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	
	public int output_c_length()
	{
		return c_length;
	}
	
	public int output_bin_length()
	{
		return (c_length<<3);
	}
	
	public char [] output_c()
	{
		return c;
	}
	
	public void encrypt(String f) throws Exception
	{
		blowfish bf = new blowfish();
		bf.setUp(f);
		byte[] encryptionBytes = null;
		String enter = String.valueOf(c);
		encryptionBytes = bf.encrypt(enter);
		
		c = new char [encryptionBytes.length];
		for(int i=0; i<encryptionBytes.length;i++)
		{
			c[i] = (char)encryptionBytes[i];
		}
		
		
		//System.out.println(c);
	}
	
	public int [] output_bin()
	{
		bin = new int [16*c.length];
		int ch;
		for(int i=0;i<c.length;i++)
		{
			ch = (int)(c[i]);
			//System.out.println(ch);
			for(int j=0;j<16;j++)
			{
				bin[i*16+j] = ch&1;
				ch =ch >> 1;
			}
		}
		//System.out.println(c);
		return bin;
	}
	
}
