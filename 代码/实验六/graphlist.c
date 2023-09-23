/**
* @file graphlistutil.c
* @brief ͼ���ڽӱ��ʾ�Լ���������
*/

#include <stdlib.h>
#include <stdio.h>
#include "LinkQueue.h"
#include "graphlist.h"
/**
  * @brief  ��ʼ��ͼ
  * @param[in]   num    ͼ�н��ĸ���
  * @return    ���ڽӱ��ʾ��ͼ
  */
GraphList* InitGraph(int num)
{
	int i;
	GraphList *graphList = (GraphList *)malloc(sizeof(GraphList));

	graphList->size = num;
	graphList->graphListArray = (GraphListNode*)malloc(sizeof(GraphListNode)*num);

	for (i=0; i<num; i++)
	{
		graphList->graphListArray[i].next = NULL;
		graphList->graphListArray[i].nodeno = i;
	}

	return graphList;
}
/**
  * @brief  �����ݶ���ͼ��
  * @param[in]   graphList    ͼ
  */
void ReadGraph(GraphList* graphList)
{
	int vex1, vex2;
	GraphListNode *tempNode = NULL;
	/** ���뷽ʽΪ�� �� ����Ϊ-1����������� */
	printf("�����룬���뷽ʽΪ�� �� ����Ϊ-1�����������\n");
	scanf("%d%d", &vex1, &vex2);

	while(vex1>=0 && vex2>=0)
	{
		tempNode = (GraphListNode*)malloc(sizeof(GraphListNode));
		tempNode->nodeno = vex2;
		tempNode->next = NULL;

		/**Ѱ�ҵ�Ҫ������ĵط�������Ϊ�˷���ͷ���ͷ��*/
		tempNode->next = graphList->graphListArray[vex1].next;
		graphList->graphListArray[vex1].next = tempNode;
		scanf("%d%d", &vex1, &vex2);
	}
}

/**
  * @brief  ��ͼ�Ľṹ��ʾ����
  * @param[in]   graphList    ͼ
  */
void WriteGraph(GraphList* graphList)
{
	int i;
	GraphListNode *tempNode = NULL;

	for (i=0; i<graphList->size; i++)
	{
		/**���ÿ������Ľ��*/
		tempNode = graphList->graphListArray[i].next;

		while(tempNode != NULL)
		{
			printf("���%d��%d����\n",i,tempNode->nodeno);
			tempNode = tempNode->next;
		}
	}
}


/**
  * @brief  ͼ��������ȱ����ݹ��㷨���ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */
void DFS(GraphList* graphList, int * visited, int i)
{

	GraphListNode *tempNode = NULL;
	visited[i] = 1;
	printf("%d ", i);

	//for(j = 0; j < graphList->size; j++)
	tempNode = graphList->graphListArray[i].next;
	while(tempNode != NULL)
	{
		if(!visited[tempNode->nodeno])
			DFS(graphList, visited, tempNode->nodeno);
		tempNode = tempNode->next;
	}
}

/**
  * @brief  ��ȱ������ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  */
void DFSGraphList(GraphList* graphList)
{
	int i;
	/** ���ڼ�¼ͼ����Щ����Ѿ��������� */
	int *visited = (int*)malloc(sizeof(int) * graphList->size);

	/** ��ʼ��Ϊ�㶼û�б����� */
	for(i = 0; i < graphList->size; i++)
		visited[i] = 0;

	for(i = 0; i < graphList->size; i++)
		if(!visited[i]) /* ��δ���ʹ��Ķ������DFS��������ͨͼ��ֻ��ִ��һ�� */
			DFS(graphList, visited, i);
}

/**
  * @brief  ͼ�Ĺ�����ȱ����ݹ��㷨���ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */
void BFS(GraphList* graphList, int * visited, int i)
{
	int tempVex;
	GraphListNode *tempNode = NULL;
	/** ������ȱ���ʹ�õĶ�����c++��STL�е�queue */
	LinkQueue waitingQueue = NULL;
	waitingQueue = SetNullQueue_Link();

	/** ���û�з��ʹ�������� */
	if (!visited[i])
	{
		/** ���ñ�ǣ������Ѿ������� */
		visited[i] = 1;
		/** ������ʵĽ���� */
		printf("%d ", i);
		/** ���շ��ʵĽ�������� */
		EnQueue_link(waitingQueue,i);

		/** ���ʽ�㣭������� */
		while(!IsNullQueue_Link(waitingQueue))
		{
			tempVex = FrontQueue_link(waitingQueue);
			DeQueue_link(waitingQueue);

			/**���η����뵱ǰ������ڵĵ�*/
			tempNode = graphList->graphListArray[tempVex].next;
			while(tempNode != NULL)
			{
				/**������������뵱ǰ������ڱ���δ���ʹ�  */
				if(!visited[tempNode->nodeno])
				{
					/**�����*/
					visited[tempNode->nodeno] = 1;
					/**���*/
					EnQueue_link(waitingQueue, tempNode->nodeno);
					/**���*/
					printf("%d ", tempNode->nodeno);

				} //end if(!visited[tempNode->nodeno])
				/**�ƶ�����һ�����*/
				tempNode = tempNode->next;
			} //end while(tempNode != NULL)
		}//end while(!waitingQueue.empty())
	}//end if (!visited[i])
}


/**
  * @brief  ͼ�Ĺ�����ȱ������ڽӱ��ʾͼ
  * @param[in]   graphList    ͼ
  */
void BFSGraphList(GraphList* graphList)
{
	int i;

	/** ���ڼ�¼ͼ����Щ����Ѿ��������� */
	int *visited = (int*)malloc(sizeof(int) * graphList->size);

	/** �������н�㶼û�б����ʣ�����1Ϊ���ʹ���0Ϊû�б����� */
	for(i = 0; i < graphList->size; i++)
		visited[i] = 0;

	/** ��0�Ž�㿪ʼ���й�����ȱ��� */
	for(i = 0; i < graphList->size; i++)
	{
		BFS(graphList, visited, i);
	}//end for(i = 0; i < graphList->size; i++)
}
