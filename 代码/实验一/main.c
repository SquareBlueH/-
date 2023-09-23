#include <stdio.h>
#include <stdlib.h>
#include"SeqList.h"

int main ()
{
    int m,len,i,x,j;
    SeqList La;
    printf("请输入表的容量：");
    scanf("%d",&m);
    La=SetNullList_Seq(m);
    printf("请输入表的长度：");
    scanf ("%d",&len);
    printf ("请输入元素值：");
    for(i=0;i<len;i++)
    {
        scanf("%d",&x);
        InsertPre_seq(La,i,x);
    }
    printf ("初始化后的La:");
    print(La);

    printf ("请输入删除第i个元素：");
    scanf("%d",&i);
    j=DelIndex_seq(La,i-1) ;
    if(j==1)
    {
    printf("删除后的La：");
    print(La);
    }
    else{
    printf("不存在此元索，删除失败。");
    }

    printf("\n请输入第i个位置插入B：");
    scanf("%d%d",&i,&x);
    j=InsertPre_seq(La,i,x);
    if(j==1)
    {
        printf("插入后的La：");
        print(La);

    }
    else{
        printf("插入位置不合法，插入失败。\n");
    }
    binsearch(La,x,&j);
    return 0;
}
