#include <stdio.h>
//#include "unif01.h"

static unsigned int x = 23456677;
static unsigned int y = 36456477;
static long long b  = 1253543677;
static unsigned int state1 =12;
static unsigned int table1[16] = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4};
static unsigned int table2[16] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
static unsigned int table3[5] = {0, 1, 5, 11, 15};
static unsigned int table4[5] = {1, 4, 6, 4, 1};

void xorshift2()
{
	y = y ^ (y<< 5);
	y = y ^ (y>>13);
	y = y ^ (y<< 6);
}

void xorshift1()
{
	x = x ^ (x<<11);
	x = x ^ (x>>13);
	x = x ^ (x<< 5);
}

void bbs()
{
	b = (b * b) % 4292870399L ;
}

unsigned int LUT_CI(unsigned int input1, unsigned int input2)
{
	int m = table1[input1];
	int n = table3[m];
	int t = table4[m];
	int w = table2[n+(input2%t)];
	return w;
}

int main()
{
	int i,j;
	unsigned int t;
	for (i = 0;i < 200000/4; i++)
	{
		xorshift1();
		bbs();
		xorshift2();
		t = LUT_CI(x&15,y);
		for(j=0;j<4;j++)
		{
			printf("%d",((t>>j)&1));
		}
	}
	return 0;
}


