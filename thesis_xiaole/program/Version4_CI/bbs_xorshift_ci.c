#include <stdio.h>
#include "unif01.h"

static long long x1 = 11234525;
void XORshift1()
{
    x1 = x1 ^ (x1 << 13);
    x1 = x1 ^ (x1 >> 35);
    x1 = x1 ^ (x1 << 30);
}


static long long x2 = 453264536;
void XORshift2()
{
    x2 = x2 ^ (x2 << 23);
    x2 = x2 ^ (x2 >> 13);
    x2 = x2 ^ (x2 << 58);
}

static long long x3 = 89804324;
void XORshift3()
{
    x3 = x3 ^ (x3 << 31);
    x3 = x3 ^ (x3 >> 25);
    x3 = x3 ^ (x3 << 37);
}


static long long b = 231423;
static unsigned int m = 4292870399;
void bbs()
{
    b = (b*b)%m;
}

static unsigned int s = 1;

unsigned int bbs_xorshift_ci()
{
    XORshift1();
    XORshift2();
    XORshift3();
    bbs();
    if((b & 1)!= 0)
        s = s ^ (unsigned int)(x1 >> 32);
    s = s ^ (unsigned int)(x1 & 0xffffffff);
    if((b & 2)!=0)
        s = s ^ (unsigned int)(x2 >> 32);
    s = s ^ (unsigned int)(x2 & 0xffffffff);
    if((b & 4)!=0)
        s = s ^ (unsigned int)(x3 >> 32);
    s = s ^ (unsigned int)(x3 & 0xffffffff);
    
    return s;
}

unsigned int bbs_xorshift_ci1()
{
    XORshift1();
    XORshift2();
   // XORshift3();
    bbs();
    if((b & 1))
    {
       //printf("in 1 %d\n",(b & 1));
        s = s ^ (unsigned int)(x1 >> 32);
    }
    if((b & 2))
    {
        //printf("in 2 %d\n",(b & 2));
        s = s ^ (unsigned int)(x1 & 0xffffffff);
    }
    if((b & 4))
    {
        //printf("in 4 %d\n",(b & 4));
        s = s ^ (unsigned int)(x2 >> 32);
    }
    s = s ^ (unsigned int)(x2 & 0xffffffff);
    return s;
}

//int main()
//{
//    int i;
//    XORshift1();
//    for(i=0;i<64;i++){printf("%d",((x1>>i)&1));}
//    printf("\n");
//    XORshift2();
//    for(i=0;i<64;i++){printf("%d",((x2>>i)&1));}
//    printf("\n");
//    XORshift3();
//    for(i=0;i<64;i++){printf("%d",((x3>>i)&1));}
//    printf("\n");
//    bbs();
//    for(i=0;i<64;i++){printf("%d",((x3>>i)&1));}
//    printf("\n");
//}
/*
int main()
{
    unif01_Gen *gen;
    
    gen = unif01_CreateExternGenBits ("bbs_xorshift_ci1",bbs_xorshift_ci1);
    //bbattery_SmallCrush (gen);
   //bbattery_Crush (gen);
    bbattery_BigCrush (gen);
   // bbattery_Rabbit (gen,1000000000.0);
    // bbattery_Alphabit (gen,1000000000.0,0,32);
     
     //bbattery_pseudoDIEHARD(gen);
     //bbattery_FIPS_140_2(gen);
     //unif01_DeleteExternGenBits (gen);
     
     return 0;
}// generate for TestU01 gcc bbs_xorshift_ci.c -ltestu01 -lprobdist -lmylib -lm

*/
 //generate for nist
int main()
{
    int i,j;
    for (i=0;i<100000000/32;i++)
    {
        bbs_xorshift_ci1();
        for (j=0;j<32;j++)
        {
            printf("%u",((s>>j)&1));
        }
    }
}
