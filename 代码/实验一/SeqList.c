#include<stdio.h>
#include<stdlib.h>

#include "SeqList.h"
//特别注意需要包含前面定义的头文件，用双引号，与包含c库的方法不同
SeqList SetNullList_Seq(int m)//创建空顺序表
{
	//申请结构体List空间
	SeqList slist = (SeqList)malloc(sizeof(struct List));
	if (slist != NULL){
		slist->elem = (DataType*)malloc(sizeof(DataType)*m);
		//申请顺序表空间，大小为m个DataType空间*/
		if (slist->elem){
			slist->Max = m;     //顺序表的最大值
			slist->n = 0;       //顺序表长度赋值为0
			return(slist);
		}
		else free(slist);
	}
	printf("out of space!!\n");
	return NULL;
}
int IsNullList_seq(SeqList slist)  //判断顺序表是否为空
{
	return(slist->n == 0);  //检查顺序表的长度是否为初始设置的0
}

//在线性表slist的p位置之前插入x
int InsertPre_seq(SeqList slist, int p, DataType x)
{
	int q;
	if (slist->n >= slist->Max){ /*顺序表满溢出*/
		printf("overflow");
		return(0);
	}
	if (p<0 || p>slist->n){  //不存在下标为p的元素

		return(0);
	}
	for (q = slist->n - 1; q >= p; q--)//插入位置以及之后的元素后移
		slist->elem[q + 1] = slist->elem[q];
	slist->elem[p] = x;  //插入元素x
	slist->n = slist->n + 1;  //顺序表长度加1
	return(1);
}
int DelIndex_seq(SeqList slist, int p) //删除下标为p的元素
{
	int q;
	if (p<0 || p>=slist->n){//不存在下标为p的元素

		return 0;
	}
	for (q = p; q<slist->n - 1; q++){ //p位置之后的元素向前移动
		slist->elem[q] = slist->elem[q + 1];
	}
	slist->n = slist->n - 1; //顺序表长度减1
	return 1;
}
int Locate_seq(SeqList slist, int x)//查找值为x的元素
{
	int q;
	for (q = 0; q<slist->n; q++){
		if (slist->elem[q] == x)//查找成功，返回对应的位置
			return q;
	}
	return -1;                   //查找失败，返回-1
}

int binsearch(SeqList slist, int key, int *pos)
{
	int index = 1;//比较次数
	int mid;
	int low = 0;
	int high = slist->n - 1;
	while (low <= high)
	{
		mid = (low + high) / 2;
		if (slist->elem[mid] == key) {
			*pos = mid;
			printf("找到,共进行%d次比较，", index);
			printf("要找的数据%d在第%d个位置上。\n", key, mid+1);
			return 1;
		}
		else if (slist->elem[mid] > key)
			high = mid - 1;
		else 	low = mid + 1;
		index++;
	}
	*pos = low;
	printf("没有找到,共进行%d次比较，", index - 1);
	printf("可将此数插入到下标为%d上。\n", *pos);
	return -1;
}

void print(SeqList slist)    //输出顺序表
{
	int i;
	for (i = 0; i<slist->n; i++)    //依次遍历顺序表，并输出
		printf("%d ", slist->elem[i]);
	printf("\n");
}
void DestoryList_Seq(SeqList slist)    //释放顺序表
{
	free(slist);
}
