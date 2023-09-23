#include <stdlib.h>
#include <stdio.h>
#include "SeqStack.h"
SeqStack SetNullStack_Seq(int m)  //创建空顺序栈
{
	SeqStack sstack = (SeqStack)malloc(sizeof(struct SeqStack));
	if (sstack != NULL){
		sstack->elem = (int*)malloc(sizeof(int)*m);
		if (sstack->elem != NULL){
			sstack->MAX = m;
			sstack->top = -1;
			return(sstack);
		}
		else {
			free(sstack);
			return NULL;
		}
	}
	else{
		printf("out of space");
		return NULL;
	}
}

int IsNullStack_seq(SeqStack sstack) //判断一个栈是否为空
{
	return(sstack->top == -1);
}
void Push_seq(SeqStack sstack, int x)  //入栈
{
	if (sstack->top >= (sstack->MAX - 1))  //检查栈是否满
		printf("overflow! \n");
	else{
		sstack->top++; //若不满，先修改栈顶变量
		sstack->elem[sstack->top] = x;//把元素x放到栈顶变量的位置中
	}
}
void Pop_seq(SeqStack sstack)//出栈
{
	if (IsNullStack_seq(sstack)) //判断栈是否为空
		printf("Underflow!\n");
	else
		sstack->top = sstack->top - 1;//栈顶减1
}
DataType Top_seq(SeqStack sstack)//求栈顶元素的值
{
	if (IsNullStack_seq(sstack))//判断sstack所指的栈是否为空栈
	{
		printf("it is empty");
		return 0;
	}
	else
		return sstack->elem[sstack->top];
}