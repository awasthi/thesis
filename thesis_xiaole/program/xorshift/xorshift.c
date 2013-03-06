#include <stdio.h>
static unsigned int x = 1231423;
void xorshift()
{
	x = x ^ (x << 11);
	x = x ^ (x >> 13);
	x = x ^ (x << 5);
}

int main()
{
	int i,j;
	for (i=0;i<200000/32;i++)
	{
		xorshift();
		for(j=0;j<32;j++)
		printf("%d",(x>>j)&1);
	}
}
