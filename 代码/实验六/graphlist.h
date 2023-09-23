/**
* @file graphlist.h
* @brief ͼ���ڽӱ��ʾ�Լ���������
*/
#ifndef GRAPHLISTUTIL_H
#define GRAPHLISTUTIL_H

typedef struct	GRAPHLISTNODE_STRU
{
	int nodeno;/*!< ͼ�н��ı�� */
	struct	GRAPHLISTNODE_STRU* next;/*!<ָ����һ������ָ�� */
}GraphListNode;

typedef struct	GRAPHLIST_STRU
{
	int size;/*!< ͼ�н��ĸ��� */
	GraphListNode* graphListArray;/*!<ͼ���ڽӱ� */
}GraphList;

/**
  * @brief  ��ʼ��ͼ
  * @param[in]   num    ͼ�н��ĸ���
  * @return    ���ڽӱ��ʾ��ͼ
  */
GraphList* InitGraph(int num);

/**
  * @brief  �����ݶ���ͼ��
  * @param[in]   graphList    ͼ
  */
void ReadGraph(GraphList* graphList);

/**
  * @brief  ��ͼ�Ľṹ��ʾ����
  * @param[in]   graphList    ͼ
  */
void WriteGraph(GraphList* graphList);
/**
  * @brief  ͼ��������ȱ����ݹ��㷨���ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */

void DFS(GraphList* graphList, int * visited, int i);

/**
  * @brief  ��ȱ������ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  */
void DFSGraphList(GraphList* graphList);

/**
  * @brief  ͼ�Ĺ�����ȱ����ݹ��㷨���ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */

void BFS(GraphList* graphList, int * visited, int i);

/**
  * @brief  ͼ�Ĺ�����ȱ������ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  */
void BFSGraphList(GraphList* graphList);

#endif

