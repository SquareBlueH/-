#include <stdio.h>
#include <stdlib.h>
#include "LinkQueue.h"

int main()
{
    LinkQueue lqueue;
    int i;
    lqueue=SetNullQueue_Link();
    do{
        printf("��������ӵ�Ԫ�أ�");
        scanf("%d",&i);
        /*
        else if(i%2!=1){
            EnQueue_link(lqueue,i);
            printf("Ŀǰ����Ϊ��");
            print(lqueue);
            printf("\n");
        }
        else if(i%2!=0){
            DeQueue_link(lqueue);
            printf("Ŀǰ����Ϊ��");
            print(lqueue);
            printf("\n");
        }*/
        if(i==0){printf("����ѭ����");}
        else if(i%2!=1){
            EnQueue_link(lqueue,i);
            printf("�������Ԫ�غ�Ķ��У�");
            print(lqueue);
            printf("\n");
        }
        else if(i%2!=0){
            DeQueue_link(lqueue);
            if(FrontQueue_link(lqueue)==NULL){
            printf("����Ϊ�գ�");
            printf("\n");
            continue;
        }
            printf("��Ԫ��Ϊ���ӣ��ö��У�");
            print(lqueue);
            printf("\n");
        }
    }while(i!=0);
    return 0;
}
