#ifndef SEQSTACK_H
#define SEQSTACK_H

typedef int DataType;
struct SeqStack
{
	int MAX;         //最大容量
	int top;         //栈顶指针
	DataType *elem;  //存放元素的起始指针
};
typedef struct SeqStack *SeqStack;

//函数功能：创建空顺序栈
//输入参数m： 顺序栈的最大容量
//返回值：    空的顺序栈
SeqStack SetNullStack_Seq(int m);

//函数功能：判断一个栈是否为空
//输入参数sstack： 顺序栈
//返回值：    空栈返回1，否则返回0
int IsNullStack_seq(SeqStack sstack);

//函数功能：进栈
//输入参数sstack： 顺序栈
//输入参数x： 进栈元素
//返回值：    无
void Push_seq(SeqStack sstack, int x);

//函数功能：出栈
//输入参数sstack： 顺序栈
//返回值：    无
void Pop_seq(SeqStack sstack);

//函数功能：求栈顶元素的值
//输入参数sstack： 顺序栈
//返回值：    无
DataType Top_seq(SeqStack sstack);

#endif