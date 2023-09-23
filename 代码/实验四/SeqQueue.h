#ifndef SEQQUEUE_H
#define SEQQUEUE_H

typedef int DataType;

 struct Queue
 {
	 int Max;  //循环队列的最大容量
	 int f;   //队头
	 int r;   //队尾
	 DataType *elem; //队列元素起始位置
 };
typedef struct Queue *SeqQueue;

//函数功能：创建空循环队列
//输入参数： 无
//返回值：    空的循环队列
SeqQueue SetNullQueue_seq(int m);

//函数功能：判断一个循环队列是否为空
//输入参数squeue： 循环队列指针
//返回值：    空队列返回1，否则返回0
int IsNullQueue_seq(SeqQueue squeue);

//函数功能：进队
//输入参数squeue： 循环队列指针
//输入参数x： 进队元素
//返回值：    无
void EnQueue_seq(SeqQueue squeue, DataType x);

//函数功能：出队
//输入参数squeue： 循环队列指针
//返回值：    无
void DeQueue_seq(SeqQueue squeue);

//函数功能：求队头元素的值
//输入参数squeue： 循环队列指针
//返回值：    无
DataType FrontQueue_seq(SeqQueue squeue);

#endif