#include <stdio.h>
//#include "unif01.h"

static unsigned int x = 23456677;
static unsigned int y = 36456477;
static long long b  = 1253543677;
static unsigned int state1 =12;
void xorshift2()
{
	y = y ^ (y<< 5);
	y = y ^ (y>>13);
	y = y ^ (y<< 6);
}

void xorshift()
{
	x = x ^ (x<<11);
	x = x ^ (x>>13);
	x = x ^ (x<< 5);
}

void bbs()
{
	b = (b * b) % 4292870399L ;
}

int select(int input)
{
	if(input == 0)
	return 0;
	if(input>=1 && input <=4)
	return 1;
	if(input>=5 && input <=10)
	return 2;
	if(input>=11 && input <= 14)
	return 3;
	if(input == 15)
	return 4;
}

static int count = 16;
static int w[16];

void assign()
{
	int i;
	for(i=0;i<16;i++)
	{
		w[i] = ((x>>(i<<1))&3);
	}
}

void Version2_CI()
{
	xorshift2();
	bbs();
	int m = select((y&15));
	int i;
	int tmp = 0;
	while(m>0)
	{
		if(count==16)
		{
			xorshift();
			assign();
			count = 0;
		}
		if((tmp&(1<<w[count]))==0)
		{
			tmp = tmp ^ (1<<w[count]);
		    m = m - 1;
		}
		count = count + 1;
	}

	state1 = state1 ^ tmp;
}

unsigned int Version2_CI_32bit()
{
	int i;
	unsigned int out = 0;
	for(i=0;i<8;i++)
	{
		out = out << 4;
		Version2_CI();
		out = out + state1;
	}

	return out;

}

/*
int main()
{
	unif01_Gen *gen;

    gen = unif01_CreateExternGenBits ("Version2_CI",Version2_CI_32bit);
    bbattery_SmallCrush (gen);
    //bbattery_Crush (gen);
    //bbattery_BigCrush (gen);
    // bbattery_Rabbit (gen,1000000000.0);
    // bbattery_Alphabit (gen,1000000000.0,0,32);

    // bbattery_pseudoDIEHARD(gen);
    // bbattery_FIPS_140_2(gen);
     //unif01_DeleteExternGenBits (gen);

     return 0;
}

*/
int main()
{
	int i,j;
	for (i=0;i<200000/4;i++)
	{
		Version2_CI();
		for(j=0;j<4;j++)
		{
			printf("%d",((state1 >> j) & 1));
		}
	}

}

