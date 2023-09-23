#include <stdio.h>
#include <stdlib.h>
#include<time.h>
#include"sort.h"

int main()
{
    SortArray* a,*b;
    int i,m;
    int ii,jj;
    a=CreateSortArray(10);
    b=CreateSortArray(10);
    for(i=0;i<10;i++)
    {
    a->recordArray[i].key=2*(10-i);
    b->recordArray[i].key=2*(i+1)-1;
    }

//倒序排序
    InsertSort(a,&ii,&jj);
    printf("\t\t对倒序数列排序结果\t\t\t移动的次数\t\t比较的次数\n");
    printf("直接插入，");
    PrintSortArray(a);
    printf("\t\t %d\t\t %d",ii,jj);

    SelectSort(a,&ii,&jj);
    printf("\n简单排序，");
    PrintSortArray(a);
    printf("\t\t %d\t\t %d",ii,jj);

    BubbleSort(a,&ii,&jj);
    printf("\n冒泡排序，");
    PrintSortArray(a);
    printf("\t\t %d\t\t %d",ii,jj);

//顺序排序
    InsertSort(b,&ii,&jj);
    printf("\n\t\t对倒序数列排序结果\t\t\t移动的次数\t\t比较的次数\n");
    printf("直接插入，");
    PrintSortArray(b);
    printf("\t\t %d\t\t %d",ii,jj);

    SelectSort(b,&ii,&jj);
    printf("\n简单排序，");
    PrintSortArray(b);
    printf("\t\t %d\t\t %d",ii,jj);

    BubbleSort(b,&ii,&jj);
    printf("\n冒泡排序，");
    PrintSortArray(b);
    printf("\t\t %d\t\t %d",ii,jj);


    while(m!=0)
    {
        printf("\n是否进行随机数的排序\n1、输入0为否\t2、输入非0为继续：");
        scanf("%d",&m);
        if(m!=0)
        {
            unsigned int seed = time(NULL);
            for (i = 0; i < 10; i++) {
            seed+=300; //让播种时间不同
            srand(seed);
            b->recordArray[i].key=2*(i+1)-1;
            a->recordArray[i].key=rand()%100+1;
            }
            InsertSort(a,&ii,&jj);
            printf("\t\t对倒序数列排序结果\t\t\t移动的次数\t\t比较的次数\n");
            printf("直接插入，");
            PrintSortArray(a);
            printf("\t %d\t\t %d",ii,jj);

            SelectSort(a,&ii,&jj);
            printf("\n简单排序，");
            PrintSortArray(a);
            printf("\t %d\t\t %d",ii,jj);

            BubbleSort(a,&ii,&jj);
            printf("\n冒泡排序，");
            PrintSortArray(a);
            printf("\t %d\t\t %d",ii,jj);
        }
    }
    return 0;
}
