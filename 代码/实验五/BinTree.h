#ifndef BINTREE_H
#define BINTREE_H

typedef char DataType;
typedef struct BTreeNode
{
	DataType data;
	struct BTreeNode *leftchild;
	struct BTreeNode *rightchild;
}BinTreeNode;
typedef BinTreeNode *BinTree;

//函数功能： 递归建立二叉树
//输入参数： 无
//返回值：   二叉树的根
BinTree CreateBinTree_Recursion();

//函数功能： 递归先序遍历
//输入参数： 二叉树的根
//返回值：   无
void PreOrder_Recursion(BinTree bt);

//函数功能： 递归中序遍历
//输入参数： 二叉树的根
//返回值：   无
void InOrder_Recursion(BinTree bt);

//函数功能： 递归后序遍历
//输入参数： 二叉树的根
//返回值：   无
void PostOrder_Recursion(BinTree bt);

//函数功能： 销毁二叉树
//输入参数： 二叉树的根
//返回值：   无
void DestroyBinTree(BinTree bt);
//统计叶子结点数
int CountLeafNode(BinTree bt);
 //计算二叉树的深度
int CountLevel(BinTree bt);
#endif
