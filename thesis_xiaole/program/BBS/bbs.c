#include <stdio.h>
#include "unif01.h"


static long long b  = 1253543677;

void bbs()
{
	b = (b * b) % 4292870399L ; 
}

unsigned int bbs_32bit()
{
	int i;
	unsigned int out = 0;
	for(i = 0; i<8; i ++)
	{
		bbs();
		out = out << 4;
		out = out + (b&15);
	}
	return out;
}

int main()
{
	unif01_Gen *gen;
    
    gen = unif01_CreateExternGenBits ("BBS",bbs_32bit);
   // bbattery_SmallCrush (gen);
    //bbattery_Crush (gen);
    //bbattery_BigCrush (gen);
    // bbattery_Rabbit (gen,1000000000.0);
    // bbattery_Alphabit (gen,1000000000.0,0,32);
     
     //bbattery_pseudoDIEHARD(gen);
     bbattery_FIPS_140_2(gen);
     //unif01_DeleteExternGenBits (gen);
     
     return 0;
}

/*
int main()
{
	int i,j;
	for(i=0;i<100000000/4;i++)
	{
		bbs();
		for(j=0;j<4;j++)
		{
			printf("%d",(1&(b>>j)));
		}
	}
}
*/
