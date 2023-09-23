#ifndef LINKSTACK_H_
#define LINKSTACK_H_

//栈的结点定义
typedef int DataType;//入栈类型为整型
struct Node{
	DataType	  data;
	struct Node*  next;
};//指向结构体
typedef struct Node  *PNode;
typedef struct Node  *top,*LinkStack;

LinkStack SetNullStack_Link();
int IsNullStack_link(LinkStack top);
void Push_link(LinkStack top, DataType x);
void Pop_link(LinkStack top);
DataType Pop_seq_return(LinkStack top);
DataType Top_link(LinkStack top);
#endif
