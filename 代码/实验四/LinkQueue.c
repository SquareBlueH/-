#include <stdio.h>
#include <stdlib.h>
#include "LinkQueue.h"

LinkQueue  SetNullQueue_Link() //创建空队列
{
	LinkQueue lqueue;
	lqueue = (LinkQueue)malloc(sizeof(struct Queue));
	if (lqueue != NULL)
	{
		lqueue->f = NULL;
		lqueue->r = NULL;
	}
   	else
		printf("Alloc failure! \n");
	return  lqueue;
 }

int IsNullQueue_Link(LinkQueue lqueue) //判断队列是否为空
{
	return (lqueue->f == NULL);
}

void EnQueue_link(LinkQueue lqueue, DataType x) //入队
{
	PNode  p;
	p = (PNode)malloc(sizeof(struct Node));
	if (p == NULL)
		printf("Alloc failure!");
	else{
			p->data = x;
			p->next= NULL;
			if (lqueue->f == NULL) //空队列的特殊处理
			{
				lqueue->f = p;
				lqueue->r = p;
			}
	  		else
			{
				lqueue->r->next = p;
				lqueue->r = p;
			}
		}
}
void DeQueue_link(LinkQueue lqueue)  //出队
{
	struct Node  * p;
	if (lqueue->f == NULL)
		printf("");
  	else
	{
		p = lqueue->f;
		lqueue->f = lqueue->f->next;
		free(p);
	}
}
DataType  FrontQueue_link(LinkQueue lqueue) //求队头元素
{
	if (lqueue->f == NULL)
	{
		printf("警告！");
		return 0;
	}
	else
		return (lqueue->f->data);
}

void print(LinkQueue lqueue)    //输出单链表
{
	PNode  p = lqueue->f;
	while (p){
		printf("%d  ", p->data);
		p = p->next;
	}
}

