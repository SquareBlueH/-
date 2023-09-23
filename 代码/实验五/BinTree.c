#include <stdio.h>
#include <stdlib.h>
#include "BinTree.h"
//构建二叉树；特别注意这里的返回值
BinTree CreateBinTree_Recursion()
{
	char ch;
	BinTree bt;
	scanf("%c", &ch);
	if (ch == '@')//空符号
		bt = NULL;
	else
	{
		bt = (BinTreeNode *)malloc(sizeof(BinTreeNode));
		bt->data = ch;
		bt->leftchild = CreateBinTree_Recursion();
		bt->rightchild = CreateBinTree_Recursion();
	}
	return bt;
}
void PreOrder_Recursion(BinTree bt)  //递归先序遍历
{
	if (bt == NULL) return;
	printf("%c", bt->data);
	PreOrder_Recursion(bt->leftchild);
	PreOrder_Recursion(bt->rightchild);
}
void InOrder_Recursion(BinTree bt)  //递归中序遍历
{
	if (bt == NULL) return;
	InOrder_Recursion(bt->leftchild);
	printf("%c", bt->data);
	InOrder_Recursion(bt->rightchild);
}
void PostOrder_Recursion(BinTree bt)  //递归后序遍历
{
	if (bt == NULL) return;
	PostOrder_Recursion(bt->leftchild);
	PostOrder_Recursion(bt->rightchild);
	printf("%c", bt->data);
}
void DestroyBinTree(BinTree bt)  //销毁二叉树
{
	if (bt != NULL)
	{
		DestroyBinTree(bt->leftchild);
		DestroyBinTree(bt->rightchild);
		free(bt);
	}
}

int CountLeafNode(BinTree bt)  //统计叶子结点数
{
	if (bt==NULL)
		return 0;  //递归调用的结束条件
	else  //左右子树都为空，是叶子
         if((bt->leftchild==NULL)&&(bt->rightchild==NULL))
		return 1;
		 else  //递归遍历左子树和右子树
            return(CountLeafNode(bt->leftchild)
          +CountLeafNode(bt->rightchild));
}

int CountLevel(BinTree bt)  //计算二叉树的深度
{
  if (bt==NULL) return -1;          //如果空则返回0
  else
  {
   int i=CountLevel(bt->leftchild);  //递归计算左子树的深度
   int j=CountLevel(bt->rightchild);  //递归计算右子树的深度
   return (i>j?i:j)+1;            //返回两个子树中高的深度+1
  }
}

int SumNode(BinTree bt) /*递归算法求二叉树的结点总数*/
{

    int n;
    if(bt==NULL)
        return 0;
    else
    {
        n=SumNode (bt->leftchild)+SumNode (bt->rightchild);
        return n+1;
    }
}
