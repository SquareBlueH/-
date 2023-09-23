#include <stdio.h>
#include <stdlib.h>
#include "BinTree.h"

int PreOrder_search(BinTree bt,DataType x){
    int i,j,k;
    if (bt == NULL) return 0;
    if (bt->data==x)return 1;
    i=PreOrder_search(bt->leftchild,x);
    j=PreOrder_search(bt->rightchild,x);
    k=i||j;
    return k;
}
    //AB@CD@@@GLH@@K@@M@@
int main()
{
	char ch;
	int n;
	BinTree T;
	gets(ch);
	printf("���Զ������ĺ�����������@Ϊ�շ���\n");
    T=CreateBinTree_Recursion(ch);
    printf("\n�����������������");
    PreOrder_Recursion(T);
    printf("\n�����������������");
    InOrder_Recursion(T);
    printf("\n�������ĺ��������");
    PostOrder_Recursion(T);
    fflush(stdin);
    n=CountLeafNode(T);
    printf("\n��������Ҷ�ӽ������%d",n);
    n=CountLevel(T);
    printf("\n��������Ҷ����ȣ�%d",n);
    n=SumNode(T);
    printf("\n��������Ҷ�ӽ��������%d",n);

    fflush(stdin);
    printf("\n��������Ҫ���ҵ���ĸ����0��β����������");
    scanf("%c",&ch);
    while(ch!='0'){
        if(PreOrder_search(T,ch)==1)
            printf("\t���ҵ�%c�ҵ��ˣ�",ch);
        else printf("\t\t���ҵ�%cû���ҵ�����",ch);
        fflush(stdin);
        printf("\n��������Ҫ���ҵ���ĸ����0��β����������");
        scanf("%c",&ch);
    }
    printf("��������0���ѽ�����\n");
    return 0;
}
