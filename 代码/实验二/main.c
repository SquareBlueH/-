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
    printf("\nβ�巨����link1��");
    print(link1);

    printf("\n��������ҵ�λ�ã�");
    scanf("%d",&i);
    q=Locate_Link_weizhi(link1,i);
    if(q!=NULL){
        printf("\n��%d��Ԫ�ص�ֵ��%d",i,q->data);//p->data�����ҵ���λ��

    }
    else{ printf("λ�ò��Ϸ���");}

        printf("\n����������λ�ã�");
        scanf("%d",&i);
        q=Locate_Link_weizhi(link1,i);
    if(q!=NULL)
    {
        InsertPost_link(link1,q,100);
        printf("\n������link1��");
        print(link1);
    }
    else{ printf("�Ҳ���");}


    printf("\n������ɾ��link1�е�ĳ��Ԫ��ֵ��");
    scanf("%d",&i);     //�������ֵ��Ҫ�Ը���ֵ�ҵ���ɾ��
    //p = Locate_Link_weizhi(link1,i); //p�ҵ��˵ڼ������ڶ�����ֱ�����Ԫ��ֵ,ֻ�����ҵ��ڼ��������⡣ë��
    //m = &*p;
    //n = &i;
    //printf("%d",p->data)
    //printf(%d,p->data);
    //printf("%d",n);
    //fflush(stdout);ǿ��ˢ��

    //m=printf("%d",p->data);
    //print(m);
    //printf("%d",p->data);
    //printf("%d",i);
    m=Locate_Link(link1,i);//��ֵ�ҳ�Ԫ�ء�
    if(m!=NULL)
        {                   //if��䲻��ʹ��==2022/10/6-01.04���������
        DelNode_Link(link1,i);                  //ë����
        //DelNode_Link(link1,0);
        printf("\nɾ�����link1��Ԫ�����У�");
        print(link1);
        }
        else {printf("�����������ֵ");}
    MoveMaxToTail(link1);
    printf("\n�ֽ��������ֵ����β�����õ���list1���У�");
    print(link1);

    return 0;
}
