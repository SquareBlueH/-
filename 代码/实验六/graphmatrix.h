
#ifndef GRAPHMATRIXUTIL_H_
#define GRAPHMATRIXUTIL_H_
#define INT_MAX 10000
/**
 * @brief ͼ���ڽӾ����ʾ
 */
typedef struct	GRAPHMATRIX_STRU
{
    char*vex;//��abcdef��һ��
	int size;/*!< ͼ�н��ĸ��� */
	int **graph;/*!<��ά���鱣��ͼ */
}GraphMatrix;

/**
  * @brief  ��ʼ��ͼ
  * @param[in]   num    ͼ�н��ĸ���
  * @return    ���ڽӾ����ʾ��ͼ
  */

GraphMatrix* InitGraph(int num);

/**
  * @brief  �����ݶ���ͼ��
  * @param[in]   graphMatrix    ͼ
  */

int LocateVexM(GraphMatrix *G,char v);

void ReadGraph(GraphMatrix* graphMatrix);

/**
  * @brief  ��ͼ�Ľṹ��ʾ����
  * @param[in]   graphMatrix    ͼ
  */
void WriteGraph(GraphMatrix* graphMatrix);
/**
  * @brief  ͼ��������ȱ����ݹ��㷨���ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */
void DFS(GraphMatrix* graphMatrix, int * visited, int i);

/**
  * @brief  ��ȱ������ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  */
void DFSGraphMatrix(GraphMatrix* graphMatrix);

/**
  * @brief  ͼ�Ĺ�����ȱ����ݹ��㷨���ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */
void BFS(GraphMatrix* graphMatrix, int * visited, int i);

/**
  * @brief  ͼ�Ĺ�����ȱ������ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  */
void BFSGraphMatrix(GraphMatrix* graphMatrix);
#endif

