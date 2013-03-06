import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;



public class read_graphic {
	private BufferedImage img = null;
	private long [][] pixels;
	private Graphics big;
	private int h;
	private int w;
	private String s;
	int graphic_error = 1;
	
	public void init(String name)
	{
		s = name;
	}
	
	public void process()
	{
		try
		{
			img = ImageIO.read(new File(s));
			pixels = new long [img.getHeight()] [ img.getWidth()];
			h = img.getHeight();
			w = img.getWidth();
			graphic_error = 0;
		}catch(IOException e)
		{
			graphic_error = 1;
		}
	}
	
	public long [][] output()
	{
		return pixels; 
	}
	
	public int output_h()
	{
		return h;
	}
	
	public int output_w()
	{
		return w;
	}
	
	public BufferedImage output_image()
	{
		return img;
	}
}
