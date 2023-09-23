#ifndef SORT_H_
#define SORT_H_
typedef int KeyType; //关键字的数据类型
typedef int InfoType; //其余数据信息的数据类型
//待排序记录的数据类型
typedef struct	RECORDTYPE_STRU{
	KeyType key;// 关键字
	InfoType otherInfo;//其余数据信息
}RecordType;
//存放多个待排序数据的结构体。需要进行空间分配的一维数组
typedef struct	SORTARRAY_STRU{
	int cnt;// 要排序的数组中的元素个数
	RecordType *recordArray;//指向一维数组的指针
}SortArray;

//函数功能：创建用于排序的一维数组
//输入参数num ： 创建的一维数组内包含的元素个数
//返回值：一维数组
SortArray* CreateSortArray(int num);

//函数功能： 输出一维数组中的元素
void PrintSortArray(SortArray* sortArray);

//函数功能：交换一维数组中两个元素的值
//输入参数i：要交换的两个元素下标之一
//输入参数 j:要交换的两个元素下标之一
void  Swap(SortArray* sortArray, int i, int j);

//函数功能：直接插入排序
//输入参数 sortArray  ：  要排序的数组
void InsertSort(SortArray* sortArray,int*ii,int*jj);

//函数功能：直接选择排序
//输入参数  sortArray ：   要排序的数组
void  SelectSort(SortArray *sortArray,int*ii,int*jj);

//函数功能： 冒泡排序，升序
//输入参数sortArray  ：  用于进行排序的一维数组
void BubbleSort(SortArray* sortArray,int*ii,int*jj);



#endif
