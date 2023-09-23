#include <stdio.h>
#include <stdlib.h>
#include "openaddresshash.h"
#include <time.h>

int h(KeyType key, int size)
{
    return (key%size);
}
void PrintHashTable(HashTable* hashTable,int size)
{
    int i;
    for(i=0;i<size;i++)
    {
        printf("%d  ",hashTable->data[i].key);
    }
    printf("\n");
}

int main()
{
    HashTable *hashTable = NULL;
    int i,x,p;
    Element tempElement;
    hashTable = CreateHashTable(13);
    srand((unsigned)time(NULL));
    for(i=0;i<10;i++)
    {
        tempElement.key = rand()%100+1;
        InsertHashTable(hashTable,tempElement);
    }
    printf("创建的散列表为：\n");
    PrintHashTable(hashTable,13);

    printf("输入要查找的数：\n");
    scanf("%d",&x);
    i = SearchHashTable(hashTable,x,&p);
    if(i==0)
        printf("\n不存在该值！\n");
    else
        printf("%d在散列表第%d个位置\n",x,p+1);

    printf("输入要删除的数：\n");
    scanf("%d",&x);
    i=DeleteHashTable(hashTable,x);
    if(i==1)
    {
        printf("您删除后的散列表为：\n");
        PrintHashTable(hashTable,13);
    }
    else{printf("删除失败\n");}

    printf("输入要插入的数：\n");
    scanf("%d",&x);
    tempElement.key = x;
    i=InsertHashTable(hashTable,tempElement);
    if(i==1)
    {
        printf("插入%d后的散列表为：\n",x);
        PrintHashTable(hashTable,13);
    }
    else{printf("插入失败\n");}
    return 0;
}
