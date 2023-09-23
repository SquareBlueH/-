#include <stdio.h>
#include <stdlib.h>
#include"LinkList.h"

PNode Locate_Link_weizhi(LinkList llist,int i)
{
    PNode p;
    int j=1;
    if (llist == NULL )return NULL;
    p = llist->next;
    while (p!= NULL&&j<i)
    {
        j++;
        p = p->next;
    }
    return p;
}
int main()
{
    LinkList link1;
    int i,m;
    PNode q,p;
    link1=SetNullList_Link();
    CreateList_Tail(link1);
    printf("\n尾插法创建link1：");
    print(link1);

    printf("\n请输入查找的位置：");
    scanf("%d",&i);
    q=Locate_Link_weizhi(link1,i);
    if(q!=NULL){
        printf("\n第%d个元素的值：%d",i,q->data);//p->data返回找到的位置

    }
    else{ printf("位置不合法！");}

        printf("\n请输入插入的位置：");
        scanf("%d",&i);
        q=Locate_Link_weizhi(link1,i);
    if(q!=NULL)
    {
        InsertPost_link(link1,q,100);
        printf("\n插入后的link1：");
        print(link1);
    }
    else{ printf("找不到");}


    printf("\n请输入删除link1中的某个元素值：");
    scanf("%d",&i);     //输入的数值就要以该数值找到和删除
    //p = Locate_Link_weizhi(link1,i); //p找到了第几个存在而不是直接输出元素值,只关心找到第几个的问题。毛病
    //m = &*p;
    //n = &i;
    //printf("%d",p->data)
    //printf(%d,p->data);
    //printf("%d",n);
    //fflush(stdout);强行刷新

    //m=printf("%d",p->data);
    //print(m);
    //printf("%d",p->data);
    //printf("%d",i);
    m=Locate_Link(link1,i);//用值找出元素。
    if(m!=NULL)
        {                   //if语句不能使用==2022/10/6-01.04，错误错误。
        DelNode_Link(link1,i);                  //毛病个
        //DelNode_Link(link1,0);
        printf("\n删除后的link1的元素序列：");
        print(link1);
        }
        else {printf("不存在这个数值");}
    MoveMaxToTail(link1);
    printf("\n现将链表最大值移至尾部，得到的list1序列：");
    print(link1);

    return 0;
}
