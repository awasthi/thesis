#include <stdio.h>
//#include "unif01.h"

static unsigned int x = 23456677;
static unsigned int y = 36456477;
static unsigned int z = 96857323;
static long long b  = 1253543677;
static unsigned int state1 =12;
static unsigned int state2 =9;
static unsigned int state3 =7;
static unsigned int u = 49320200;
void xorshift4()
{
    u = u ^ (u<<1);
	u = u ^ (u>>3);
	u = u ^ (u<<10);
}

void xorshift1()
{
	x = x ^ (x<<11);
	x = x ^ (x>>13);
	x = x ^ (x<< 5);
}

void xorshift2()
{
	y = y ^ (y<< 5);
	y = y ^ (y>>13);
	y = y ^ (y<< 6);
}

void xorshift3()
{
	z = z ^ (z<<14);
	z = z ^ (z>>13);
	z = z ^ (z<<15);
}

void bbs()
{
	b = (b * b) % 4292870399L ;
}

void Version1_CI()
{
	bbs();
	xorshift1();
	xorshift2();
	xorshift3();
	xorshift4();
	int c = 12 + (b&1);
	int i;
	int w;
	int tmp = 0;
	for(i=0;i<c;i++)
	{
		w = (x>>(2*i))&3;
		tmp = tmp ^ (1<<w);
	}
	state1 = tmp ^ state1;

	c = 12 + ((b>>1) & 1);
	tmp = 0;
	for(i=0;i<c;i++)
	{
		w = (y>>(2*i))&3;
		tmp = tmp ^ (1<<w);
	}
	state2 = tmp ^ state2;

	c = 12 + ((b>>2) & 1);
	tmp = 0;
	for(i=0;i<c;i++)
	{
		w = (z>>(2*i))&3;
		tmp = tmp ^ (1<<w);
	}
	state3 = tmp ^ state3;
}

int main()
{
	int i,j;
	for(i=0;i<100000000/12+1;i++)
	{
		Version1_CI();
		for(j=0;j<4;j++)
		{
			printf("%d",((state1>>j)&1));

		}
		for(j=0;j<4;j++)
		{

			printf("%d",((state2>>j)&1));
		}
		for(j=0;j<4;j++)
		{

			printf("%d",((state3>>j)&1));
		}
	}
	return 0;
}

/*
unsigned int Version1_CI_32bits()
{
	unsigned int out = 0;
	int i;
	for(i=0;i<4;i++)
	{
		Version1_CI();
		out = out + (state1<<8*i);
		out = out + (state2<<(8*i+4));
	}
	return out;
}




int main()
{
	unif01_Gen *gen;

    gen = unif01_CreateExternGenBits ("Version1_CI",Version1_CI_32bits);
    //bbattery_SmallCrush (gen);
    //bbattery_Crush (gen);
    //bbattery_BigCrush (gen);
    // bbattery_Rabbit (gen,1000000000.0);
    // bbattery_Alphabit (gen,1000000000.0,0,32);

    // bbattery_pseudoDIEHARD(gen);
     bbattery_FIPS_140_2(gen);
     //unif01_DeleteExternGenBits (gen);

     return 0;
}

*/
