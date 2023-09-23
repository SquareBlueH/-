#ifndef SEQLIST_H
#define SEQLIST_H

typedef int DataType;     //数据元素类型定义为整型
struct List
{
	int Max;  //顺序表的最大容量
	int n;    //顺序表长度
	DataType *elem; //顺序表元素起始位置
};
typedef struct List *SeqList;  //顺序表类型定义

//函数功能： 创建空顺序表
//输入参数 m： 顺序表的最大容量
//返回值： 空的顺序表
SeqList SetNullList_Seq(int m);

//函数功能： 判断顺序表是否为空
//输入参数 slist： 顺序表
//返回值： 空返回1，否则返回0
int IsNullList_seq(SeqList slist);

//函数功能： 在线性表slist的p位置之前插入x
//输入参数 slist： 顺序表
//输入参数 p： 插入位置
//输入参数 x: 待插入的元素
//返回值： 成功返回1，否则返回0
int InsertPre_seq(SeqList slist, int p, DataType x);

//函数功能： 删除下标为p的元素
//输入参数 slist： 顺序表
//输入参数 p： 删除位置
//返回值： 成功删除返回1，否则返回0
int DelIndex_seq(SeqList slist, int p);

//函数功能： 查找值为x的元素
//输入参数 slist： 顺序表
//输入参数 x： 要查找的元素
//返回值： 查找成果返回元素在顺序表的下标，否则返回-1
int Locate_seq(SeqList slist, int x);

//函数功能： 输出顺序表
//输入参数 slist： 顺序表
//返回值： 无
void print(SeqList slist);

//函数功能： 释放顺序表
//输入参数 slist： 顺序表
//返回值： 无
void DestoryList_Seq(SeqList slist);

//二分查找
int binsearch(SeqList slist, int key, int *pos);
#endif
