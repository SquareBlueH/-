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
	printf("请以二叉树的函数创建，用@为空符号\n");
    T=CreateBinTree_Recursion(ch);
    printf("\n二叉树的先序遍历：");
    PreOrder_Recursion(T);
    printf("\n二叉树的中序遍历：");
    InOrder_Recursion(T);
    printf("\n二叉树的后序遍历：");
    PostOrder_Recursion(T);
    fflush(stdin);
    n=CountLeafNode(T);
    printf("\n二叉树的叶子结点数：%d",n);
    n=CountLevel(T);
    printf("\n二叉树的叶子深度：%d",n);
    n=SumNode(T);
    printf("\n二叉树的叶子结点总数：%d",n);

    fflush(stdin);
    printf("\n请输入想要查找的字母，以0结尾当做结束：");
    scanf("%c",&ch);
    while(ch!='0'){
        if(PreOrder_search(T,ch)==1)
            printf("\t你找的%c找到了！",ch);
        else printf("\t\t你找的%c没有找到！！",ch);
        fflush(stdin);
        printf("\n请输入想要查找的字母，以0结尾当做结束：");
        scanf("%c",&ch);
    }
    printf("您已输入0，已结束！\n");
    return 0;
}
