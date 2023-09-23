#ifndef LINKLQUEUE_H
#define LINKLQUEUE_H
typedef int DataType;
struct Node
{
	DataType data;   //数据域
	struct Node	*next;
};
typedef struct Node *PNode;
struct Queue
{	PNode		f;
	PNode		r;
};
typedef struct Queue *LinkQueue;

//函数功能：创建空链队列
//输入参数： 无
//返回值：    空的链队列
LinkQueue SetNullQueue_Link();

//函数功能：判断一个链队列是否为空
//输入参数lqueue： 链队指针
//返回值：    空队列返回1，否则返回0
int IsNullQueue_Link(LinkQueue lqueue);

//函数功能：进队
//输入参数lqueue： 链队指针
//输入参数x： 进队元素
//返回值：    无
void EnQueue_link(LinkQueue lqueue, DataType x);

//函数功能：出队
//输入参数lqueue： 链队指针
//返回值：    无
void DeQueue_link(LinkQueue lqueue);

//函数功能：求队头元素的值
//输入参数lqueue： 链队指针
//返回值：    无
void print(LinkQueue lqueue);

DataType  FrontQueue_link(LinkQueue lqueue);

#endif
