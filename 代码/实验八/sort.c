#include "sort.h"
#include<malloc.h>
#include<stdio.h>
// 创建用于排序的一维数组
SortArray* CreateSortArray(int num) {
	SortArray *sortArray = (SortArray*)malloc(sizeof(SortArray));
	sortArray->cnt = num;
	sortArray->recordArray
		= (RecordType *)malloc(sizeof(RecordType) * sortArray->cnt);
	return sortArray;
}

// 输出一维数组中的元素
void PrintSortArray(SortArray* sortArray){
	int i = 0;
	for (i = 0; i < sortArray->cnt; i++){

		printf("%d  ", sortArray->recordArray[i].key);
	}

}

// 交换一维数组中两个元素的值
void  Swap(SortArray* sortArray, int i, int j){
	KeyType temp;
	temp = sortArray->recordArray[i].key;
	sortArray->recordArray[i].key= sortArray->recordArray[j].key;
	sortArray->recordArray[j].key = temp;
}

//函数功能：直接插入排序,ii:移动次数，jj:比较次数
void InsertSort(SortArray* sortArray,int*ii,int*jj){
	int i, j;
	RecordType temp;

	for( i = 1; i < sortArray->cnt; i++ ) {
		//j为认为已经排好顺序的数据最后一个元素下标
		j = i-1;
		//等待插入的数据temp
		temp = sortArray->recordArray[i];
		//从j位置开始，从后向前在已经排好顺序的序列中找到插入位置
		while(temp.key < sortArray->recordArray[j].key && j>=0){
			sortArray->recordArray[j+1] = sortArray->recordArray[j];
			j--;
		}
		//找到待插入位置为j+1
		//如果待插入位置正好就是要插入元素所在位置则可以不进行数据赋值
		if( j+1 != i ) {
			sortArray->recordArray[j+1] = temp;
		}
	}//end for( i = 1; i < sortArray->cnt; i++ )
}


//函数功能：直接选择排序
void  SelectSort(SortArray *sortArray,int*ii,int*jj){
	int i, j;
	int minPos;
	// 做n-1趟选择排序
	for( i = 0; i < sortArray->cnt-1; i++ ) {
		minPos= i;
		//在无序区中寻找，记录下最小的值所在的数组下标
		for (j = i+1; j < sortArray->cnt; j++) {
			if (sortArray->recordArray[j].key < sortArray->recordArray[minPos].key){
				minPos = j;
			}
		}//end for (j = i+1; j < sortArray->cnt; j++)
		//如果需要交换再进行数据交换
		if (minPos != i)
        {
            Swap(sortArray, minPos, i);
        }

	}//end for( i = 0; i < sortArray->cnt-1; i++ )
}


//函数功能： 冒泡排序，升序
void BubbleSort(SortArray *sortArr,int*ii,int*jj)
{
	int i,j;
	int hasSwap = 0; // 标志，用于检测内循环是否还有数据交换
	for(i = 1; i < sortArr->cnt; i++)
	{
		hasSwap = 0; //每趟开始重新设置交换标志为0
		//注意j是从后往前循环 ,数组的下标是0到cnt-1
		for(j =1;j< sortArr->cnt - i+1; j++)
		{
			//若前者大于后者
	     if(sortArr->recordArray[j-1].key>sortArr->recordArray[j].key)
		  {
			Swap(sortArr, j, j-1); //交换
			hasSwap = 1; //有交换发生，则设置交换标志为1
		  }
		}
		if (!hasSwap) //本趟没有发生交换
			break;
	}
}

