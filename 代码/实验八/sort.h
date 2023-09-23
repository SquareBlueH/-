#ifndef SORT_H_
#define SORT_H_
typedef int KeyType; //�ؼ��ֵ���������
typedef int InfoType; //����������Ϣ����������
//�������¼����������
typedef struct	RECORDTYPE_STRU{
	KeyType key;// �ؼ���
	InfoType otherInfo;//����������Ϣ
}RecordType;
//��Ŷ�����������ݵĽṹ�塣��Ҫ���пռ�����һά����
typedef struct	SORTARRAY_STRU{
	int cnt;// Ҫ����������е�Ԫ�ظ���
	RecordType *recordArray;//ָ��һά�����ָ��
}SortArray;

//�������ܣ��������������һά����
//�������num �� ������һά�����ڰ�����Ԫ�ظ���
//����ֵ��һά����
SortArray* CreateSortArray(int num);

//�������ܣ� ���һά�����е�Ԫ��
void PrintSortArray(SortArray* sortArray);

//�������ܣ�����һά����������Ԫ�ص�ֵ
//�������i��Ҫ����������Ԫ���±�֮һ
//������� j:Ҫ����������Ԫ���±�֮һ
void  Swap(SortArray* sortArray, int i, int j);

//�������ܣ�ֱ�Ӳ�������
//������� sortArray  ��  Ҫ���������
void InsertSort(SortArray* sortArray,int*ii,int*jj);

//�������ܣ�ֱ��ѡ������
//�������  sortArray ��   Ҫ���������
void  SelectSort(SortArray *sortArray,int*ii,int*jj);

//�������ܣ� ð����������
//�������sortArray  ��  ���ڽ��������һά����
void BubbleSort(SortArray* sortArray,int*ii,int*jj);



#endif
