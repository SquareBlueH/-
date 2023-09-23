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
    printf("������ɢ�б�Ϊ��\n");
    PrintHashTable(hashTable,13);

    printf("����Ҫ���ҵ�����\n");
    scanf("%d",&x);
    i = SearchHashTable(hashTable,x,&p);
    if(i==0)
        printf("\n�����ڸ�ֵ��\n");
    else
        printf("%d��ɢ�б��%d��λ��\n",x,p+1);

    printf("����Ҫɾ��������\n");
    scanf("%d",&x);
    i=DeleteHashTable(hashTable,x);
    if(i==1)
    {
        printf("��ɾ�����ɢ�б�Ϊ��\n");
        PrintHashTable(hashTable,13);
    }
    else{printf("ɾ��ʧ��\n");}

    printf("����Ҫ���������\n");
    scanf("%d",&x);
    tempElement.key = x;
    i=InsertHashTable(hashTable,tempElement);
    if(i==1)
    {
        printf("����%d���ɢ�б�Ϊ��\n",x);
        PrintHashTable(hashTable,13);
    }
    else{printf("����ʧ��\n");}
    return 0;
}
