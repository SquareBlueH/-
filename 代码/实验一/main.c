#include <stdio.h>
#include <stdlib.h>
#include"SeqList.h"

int main ()
{
    int m,len,i,x,j;
    SeqList La;
    printf("��������������");
    scanf("%d",&m);
    La=SetNullList_Seq(m);
    printf("�������ĳ��ȣ�");
    scanf ("%d",&len);
    printf ("������Ԫ��ֵ��");
    for(i=0;i<len;i++)
    {
        scanf("%d",&x);
        InsertPre_seq(La,i,x);
    }
    printf ("��ʼ�����La:");
    print(La);

    printf ("������ɾ����i��Ԫ�أ�");
    scanf("%d",&i);
    j=DelIndex_seq(La,i-1) ;
    if(j==1)
    {
    printf("ɾ�����La��");
    print(La);
    }
    else{
    printf("�����ڴ�Ԫ����ɾ��ʧ�ܡ�");
    }

    printf("\n�������i��λ�ò���B��");
    scanf("%d%d",&i,&x);
    j=InsertPre_seq(La,i,x);
    if(j==1)
    {
        printf("������La��");
        print(La);

    }
    else{
        printf("����λ�ò��Ϸ�������ʧ�ܡ�\n");
    }
    binsearch(La,x,&j);
    return 0;
}
