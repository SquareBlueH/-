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

//��������
    InsertSort(a,&ii,&jj);
    printf("\t\t�Ե�������������\t\t\t�ƶ��Ĵ���\t\t�ȽϵĴ���\n");
    printf("ֱ�Ӳ��룬");
    PrintSortArray(a);
    printf("\t\t %d\t\t %d",ii,jj);

    SelectSort(a,&ii,&jj);
    printf("\n������");
    PrintSortArray(a);
    printf("\t\t %d\t\t %d",ii,jj);

    BubbleSort(a,&ii,&jj);
    printf("\nð������");
    PrintSortArray(a);
    printf("\t\t %d\t\t %d",ii,jj);

//˳������
    InsertSort(b,&ii,&jj);
    printf("\n\t\t�Ե�������������\t\t\t�ƶ��Ĵ���\t\t�ȽϵĴ���\n");
    printf("ֱ�Ӳ��룬");
    PrintSortArray(b);
    printf("\t\t %d\t\t %d",ii,jj);

    SelectSort(b,&ii,&jj);
    printf("\n������");
    PrintSortArray(b);
    printf("\t\t %d\t\t %d",ii,jj);

    BubbleSort(b,&ii,&jj);
    printf("\nð������");
    PrintSortArray(b);
    printf("\t\t %d\t\t %d",ii,jj);


    while(m!=0)
    {
        printf("\n�Ƿ���������������\n1������0Ϊ��\t2�������0Ϊ������");
        scanf("%d",&m);
        if(m!=0)
        {
            unsigned int seed = time(NULL);
            for (i = 0; i < 10; i++) {
            seed+=300; //�ò���ʱ�䲻ͬ
            srand(seed);
            b->recordArray[i].key=2*(i+1)-1;
            a->recordArray[i].key=rand()%100+1;
            }
            InsertSort(a,&ii,&jj);
            printf("\t\t�Ե�������������\t\t\t�ƶ��Ĵ���\t\t�ȽϵĴ���\n");
            printf("ֱ�Ӳ��룬");
            PrintSortArray(a);
            printf("\t %d\t\t %d",ii,jj);

            SelectSort(a,&ii,&jj);
            printf("\n������");
            PrintSortArray(a);
            printf("\t %d\t\t %d",ii,jj);

            BubbleSort(a,&ii,&jj);
            printf("\nð������");
            PrintSortArray(a);
            printf("\t %d\t\t %d",ii,jj);
        }
    }
    return 0;
}
