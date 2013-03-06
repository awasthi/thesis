
public class prng {
	private int count = 0;
	
	
	
	
	private long x = 123456,y = 78921,z = 12315,w = 56788;
	private long out;
	
	public void xorshift()
	{
		long t;
		{
			t = (x  ^ (x  << 11)) & 4294967295L;
		    x  = y & 4294967295L ; y  = z & 4294967295L ; z  = w & 4294967295L ;
		    w  = (w  ^ (w  >> 19) ^ (t ^ (t >> 8))) & 4294967295L;
		    out = w;
		}
		
	}
	
	private long a = 0x9e3779b9;
	private long b = 0x9e3779b9;
	private long c = 0x9e3779b9;
	private long d = 0x9e3779b9;
	private long e = 0x9e3779b9;
	private long f = 0x9e3779b9;
	private long g = 0x9e3779b9;
	private long h = 0x9e3779b9;
	
	public void mix_1()
	{
		a^=b<<11; d+=a; b+=c; 
		b^=c>>2;  e+=b; c+=d; 
		c^=d<<8;  f+=c; d+=e; 
		d^=e>>16; g+=d; e+=f; 
		e^=f<<10; h+=e; f+=g; 
		f^=g>>4;  a+=f; g+=h; 
		g^=h<<8;  b+=g; h+=a; 
		h^=a>>9;  c+=h; a+=b;  	 
	}
	
	public void mix()
	{
		switch(count)
		{
		case 0: mix_1(); out = a & 4294967295L; count ++; break;
		case 1: out = b & 4294967295L; count ++; break;
		case 2: out = c & 4294967295L; count ++; break;
		case 3: out = d & 4294967295L; count ++; break;
		case 4: out = e & 4294967295L; count ++; break;
		case 5: out = f & 4294967295L; count ++; break;
		case 6: out = g & 4294967295L; count ++; break;
		case 7: out = h & 4294967295L; count = 0; break;
		}
	}
	
	private long init = 0;
	
	public void mix_chaotic()
	{
		switch(count)
		{
		case 0: mix_1(); out = (init ^ a ^ b ^ c) & 4294967295L; count++; break;
		case 1: out = (init ^ d ^ e ^ f) & 4294967295L; count++; break;
		case 2: out = (init ^ g ^ h) & 4294967295L; count=0; break;
		}
	}
	
	public long output()
	{
		return out;
	}

}

