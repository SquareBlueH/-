#include <stdio.h>
#include <stdlib.h>
#include "BinTree.h"
//�������������ر�ע������ķ���ֵ
BinTree CreateBinTree_Recursion()
{
	char ch;
	BinTree bt;
	scanf("%c", &ch);
	if (ch == '@')//�շ���
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
void PreOrder_Recursion(BinTree bt)  //�ݹ��������
{
	if (bt == NULL) return;
	printf("%c", bt->data);
	PreOrder_Recursion(bt->leftchild);
	PreOrder_Recursion(bt->rightchild);
}
void InOrder_Recursion(BinTree bt)  //�ݹ��������
{
	if (bt == NULL) return;
	InOrder_Recursion(bt->leftchild);
	printf("%c", bt->data);
	InOrder_Recursion(bt->rightchild);
}
void PostOrder_Recursion(BinTree bt)  //�ݹ�������
{
	if (bt == NULL) return;
	PostOrder_Recursion(bt->leftchild);
	PostOrder_Recursion(bt->rightchild);
	printf("%c", bt->data);
}
void DestroyBinTree(BinTree bt)  //���ٶ�����
{
	if (bt != NULL)
	{
		DestroyBinTree(bt->leftchild);
		DestroyBinTree(bt->rightchild);
		free(bt);
	}
}

int CountLeafNode(BinTree bt)  //ͳ��Ҷ�ӽ����
{
	if (bt==NULL)
		return 0;  //�ݹ���õĽ�������
	else  //����������Ϊ�գ���Ҷ��
         if((bt->leftchild==NULL)&&(bt->rightchild==NULL))
		return 1;
		 else  //�ݹ������������������
            return(CountLeafNode(bt->leftchild)
          +CountLeafNode(bt->rightchild));
}

int CountLevel(BinTree bt)  //��������������
{
  if (bt==NULL) return -1;          //������򷵻�0
  else
  {
   int i=CountLevel(bt->leftchild);  //�ݹ���������������
   int j=CountLevel(bt->rightchild);  //�ݹ���������������
   return (i>j?i:j)+1;            //�������������иߵ����+1
  }
}

int SumNode(BinTree bt) /*�ݹ��㷨��������Ľ������*/
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
