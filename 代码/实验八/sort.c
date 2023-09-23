#include "sort.h"
#include<malloc.h>
#include<stdio.h>
// �������������һά����
SortArray* CreateSortArray(int num) {
	SortArray *sortArray = (SortArray*)malloc(sizeof(SortArray));
	sortArray->cnt = num;
	sortArray->recordArray
		= (RecordType *)malloc(sizeof(RecordType) * sortArray->cnt);
	return sortArray;
}

// ���һά�����е�Ԫ��
void PrintSortArray(SortArray* sortArray){
	int i = 0;
	for (i = 0; i < sortArray->cnt; i++){

		printf("%d  ", sortArray->recordArray[i].key);
	}

}

// ����һά����������Ԫ�ص�ֵ
void  Swap(SortArray* sortArray, int i, int j){
	KeyType temp;
	temp = sortArray->recordArray[i].key;
	sortArray->recordArray[i].key= sortArray->recordArray[j].key;
	sortArray->recordArray[j].key = temp;
}

//�������ܣ�ֱ�Ӳ�������,ii:�ƶ�������jj:�Ƚϴ���
void InsertSort(SortArray* sortArray,int*ii,int*jj){
	int i, j;
	RecordType temp;

	for( i = 1; i < sortArray->cnt; i++ ) {
		//jΪ��Ϊ�Ѿ��ź�˳����������һ��Ԫ���±�
		j = i-1;
		//�ȴ����������temp
		temp = sortArray->recordArray[i];
		//��jλ�ÿ�ʼ���Ӻ���ǰ���Ѿ��ź�˳����������ҵ�����λ��
		while(temp.key < sortArray->recordArray[j].key && j>=0){
			sortArray->recordArray[j+1] = sortArray->recordArray[j];
			j--;
		}
		//�ҵ�������λ��Ϊj+1
		//���������λ�����þ���Ҫ����Ԫ������λ������Բ��������ݸ�ֵ
		if( j+1 != i ) {
			sortArray->recordArray[j+1] = temp;
		}
	}//end for( i = 1; i < sortArray->cnt; i++ )
}


//�������ܣ�ֱ��ѡ������
void  SelectSort(SortArray *sortArray,int*ii,int*jj){
	int i, j;
	int minPos;
	// ��n-1��ѡ������
	for( i = 0; i < sortArray->cnt-1; i++ ) {
		minPos= i;
		//����������Ѱ�ң���¼����С��ֵ���ڵ������±�
		for (j = i+1; j < sortArray->cnt; j++) {
			if (sortArray->recordArray[j].key < sortArray->recordArray[minPos].key){
				minPos = j;
			}
		}//end for (j = i+1; j < sortArray->cnt; j++)
		//�����Ҫ�����ٽ������ݽ���
		if (minPos != i)
        {
            Swap(sortArray, minPos, i);
        }

	}//end for( i = 0; i < sortArray->cnt-1; i++ )
}


//�������ܣ� ð����������
void BubbleSort(SortArray *sortArr,int*ii,int*jj)
{
	int i,j;
	int hasSwap = 0; // ��־�����ڼ����ѭ���Ƿ������ݽ���
	for(i = 1; i < sortArr->cnt; i++)
	{
		hasSwap = 0; //ÿ�˿�ʼ�������ý�����־Ϊ0
		//ע��j�ǴӺ���ǰѭ�� ,������±���0��cnt-1
		for(j =1;j< sortArr->cnt - i+1; j++)
		{
			//��ǰ�ߴ��ں���
	     if(sortArr->recordArray[j-1].key>sortArr->recordArray[j].key)
		  {
			Swap(sortArr, j, j-1); //����
			hasSwap = 1; //�н��������������ý�����־Ϊ1
		  }
		}
		if (!hasSwap) //����û�з�������
			break;
	}
}

