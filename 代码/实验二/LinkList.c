#include<stdio.h>
#include<stdlib.h>
#include "LinkList.h" //包含前面定义的头文件，用双引号，与包含c库的方法不同
LinkList SetNullList_Link() //创建带有头结点的空链表
{
	LinkList head = (LinkList)malloc(sizeof(struct Node));
	if (head != NULL) head->next = NULL;
	else printf("alloc failure");
	return head; //返回头指针
}
int IsNull_Link(LinkList llist) //判断链表是否为空
{
	return(llist->next == NULL);
}
void CreateList_Head(struct Node *head)//头插法建立单链表
{
	PNode p = NULL;  int data;
	printf("请输入整型数据建立链表，以-1结束\n");
	scanf("%d", &data);
	while (data != -1){ /*分配空间，赋值*/
		p = (struct Node*)malloc(sizeof(struct Node));
		p->data = data;  //对数据域赋值
		p->next = head->next;   //next域赋值
		head->next = p;
		scanf("%d", &data);
	}
}
void CreateList_Tail(struct Node* head)// 尾插法建立单链表
{
	PNode p = NULL; PNode q = head; int data;
	printf("请输入整型数据建立链表，以-1结束\n");
	scanf("%d", &data);
	while (data != -1){   //分配空间，赋值
		p = (struct Node*)malloc(sizeof(struct Node));
		p->data = data;
		p->next = NULL;
		q->next = p;
		q = p;
		scanf("%d", &data);
	}
}

//在llist链表中的p位置之后插入值为x的结点
int InsertPost_link(LinkList llist, PNode p, DataType x)
{
	PNode q;
	if (p == NULL) { printf("para failure!\n"); return 0; }
	q = (PNode)malloc(sizeof(struct Node));
	if (q == NULL){
		printf("out of space!\n"); return 0;
	}
	else {
		q->data = x;
		q->next = p->next;
		p->next = q;
		return 1;
	}
}

//删除第一个与输入参数相等的值的结点
void DelNode_Link(struct Node *head, int data)
{
	PNode p = head->next; PNode beforeP = head;
	while (p != NULL){
		if (p->data == data){
			beforeP->next = p->next;
			free(p);
			break;
		}
		else{
			beforeP = p;
			p = p->next;
		}
	}
}
//在llist链表中查找值为x的结点，并返回在内存中的位置
PNode Locate_Link(LinkList llist, DataType x)
{
	PNode p;
	if (llist == NULL) return NULL;
	p = llist->next;
	while (p != NULL&&p->data != x) p = p->next;
	return p;
}

//将llist链表查找最大的节点，并移至尾部。
void MoveMaxToTail(LinkList head)
{
    PNode p, q;
    DataType temp;
    p = head->next;
    q = p->next;//p和q遍历整个数组
    while (q != NULL)
    {
        if ( p->data>q->data)
        {
            temp = q->data;
            q->data = p->data;
            p->data = temp;
        }
        else
        {
            p=q;
            q=p->next;

        }
    }
}



void print(LinkList head)    //输出单链表
{
	PNode  p = head->next;
	while (p){
		printf("%d  ", p->data);
		p = p->next;
	}
}
void DestoryList_Link(LinkList head)//释放单链表
{
	PNode  pre = head; PNode p = pre->next;
	while (p){
		free(pre);
		pre = p;
		p = pre->next;
	}
	free(pre);
}
