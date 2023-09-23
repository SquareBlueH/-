#include <stdio.h>
#include <stdlib.h>
#include "LinkQueue.h"

int main()
{
    LinkQueue lqueue;
    int i;
    lqueue=SetNullQueue_Link();
    do{
        printf("请输入入队的元素：");
        scanf("%d",&i);
        /*
        else if(i%2!=1){
            EnQueue_link(lqueue,i);
            printf("目前队列为：");
            print(lqueue);
            printf("\n");
        }
        else if(i%2!=0){
            DeQueue_link(lqueue);
            printf("目前队列为：");
            print(lqueue);
            printf("\n");
        }*/
        if(i==0){printf("跳出循环！");}
        else if(i%2!=1){
            EnQueue_link(lqueue,i);
            printf("输入入队元素后的队列：");
            print(lqueue);
            printf("\n");
        }
        else if(i%2!=0){
            DeQueue_link(lqueue);
            if(FrontQueue_link(lqueue)==NULL){
            printf("队列为空！");
            printf("\n");
            continue;
        }
            printf("此元素为出队，得队列：");
            print(lqueue);
            printf("\n");
        }
    }while(i!=0);
    return 0;
}
