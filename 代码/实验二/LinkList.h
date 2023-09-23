#ifndef LINKLIST_H
#define LINKLIST_H

typedef int DataType; //定义单链表的数据类型为整型
struct Node{
	DataType	  data;  //数据域
	struct Node*  next;  //指针域
};
typedef struct Node  *PNode;      //定义指向结构体的PNode类型
typedef struct Node  *LinkList;   //定义链表类型

//函数功能： 创建带有头结点的空链表
//输入参数 ： 无
//返回值： 空链表
LinkList SetNullList_Link();

//函数功能： 判断链表是否为空
//输入参数 ： 链表
//返回值： 空返回1，否则返回0
int IsNull_Link(LinkList llist);

//函数功能： 头插法建立单链表
//输入参数 ： 链表头结点
//返回值： 无
void CreateList_Head(struct Node *head);

//函数功能： 尾插法建立单链表
//输入参数 ： 链表头结点
//返回值： 无
void CreateList_Tail(struct Node* head);

//函数功能： 在llist链表中的结点p之后插入一个值为x的结点
//输入参数 llist ： 链表
//输入参数p： 插入位置
//输入参数x： 待插入的元素
//返回值： 成功返回1，否则返回0
int InsertPost_link(LinkList llist, PNode p, DataType x);

//函数功能： 删除第一个与输入参数相等的值的结点
//输入参数 llist ： 链表
//输入参数data： 待删除的元素
//返回值： 无
void DelNode_Link(struct Node *head, int data);

//函数功能：在llist链表中查找值为x的结点
//输入参数 llist ： 链表
//输入参数x： 查找的元素
//返回值： 在内存中的位置
PNode Locate_Link(LinkList llist, DataType x);

//函数功能：输出单链表
//输入参数 head ： 链表头结点
//返回值： 无

void remove_Link(LinkList llist);

void print(LinkList head);

//函数功能：释放单链表
//输入参数 head ： 链表头结点
//返回值： 无
void DestoryList_Link(LinkList head);//释放单链表

#endif
