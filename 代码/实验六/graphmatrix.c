/**
* @file graphmatrixutil.c
* @brief ͼ���ڽӾ����ʾ�Լ���������
*/


#include <stdlib.h>
#include <stdio.h>
#include "LinkQueue.h"
#include "graphmatrix.h"
/**
  * @brief  ��ʼ��ͼ
  * @param[in]   num    ͼ�н��ĸ���
  * @return    ���ڽӾ����ʾ��ͼ
  */
GraphMatrix* InitGraph(int num)//��ʼ��
{
	int i;
	int j;
	GraphMatrix* graphMatrix = (GraphMatrix*)malloc(sizeof(GraphMatrix));
	/** ͼ�н��ĸ��� */
	graphMatrix->size = num;
    graphMatrix->vex = (char*)malloc(sizeof(char) * graphMatrix->size);
	/** ��ͼ����ռ� */
	graphMatrix->graph = (int**)malloc(sizeof(int*) * graphMatrix->size);
	for (i=0;i<graphMatrix->size;i++)
	{
		graphMatrix->graph[i] = (int*)malloc(sizeof(int) * graphMatrix->size);
	}

	/** ��ͼ������Ԫ�����ó�ֵ */
	for (i=0;i<graphMatrix->size;i++)
	{
		for(j=0;j<graphMatrix->size;j++)
		{
			graphMatrix->graph[i][j]=INT_MAX;
		}
	}

	return graphMatrix;
}

/**
  * @brief  �����ݶ���ͼ��,��ʽΪ�� ��  Ȩֵ����������ȨֵΪ0�����������
  * @param[in]   graphMatrix    ͼ
  */
int LocateVexM(GraphMatrix *G,char v)
{
    int i;
    for(i=0;i<G->size;i++)
    {
        if(v==G->vex[i]);return 1;
    }
    return -1;
}
void ReadGraph(GraphMatrix* graphMatrix)
{
	char vex1, vex2;
	int i,weight,ii,jj;
	printf("�����붨��ֵ�����뷽ʽΪ������س�\n");
    for(i=0;i<graphMatrix->size;i++)
    {
        scanf("%c",&graphMatrix->vex[i]);
        fflush(stdin);
    }
	/** ���뷽ʽΪ�� �� Ȩֵ��ȨֵΪ0����������� */
	printf("�����룬���뷽ʽΪ��,��,Ȩֵ��ȨֵΪ0�����������\n");
	scanf("%c,%c,%d", &vex1, &vex2, &weight);

	while(weight != 0)
	{
	    ii=LocateVexM(graphMatrix,vex1);
	    jj=LocateVexM(graphMatrix,vex2);
		graphMatrix->graph[ii][jj] = weight;
	scanf("%c,%c,%d", &vex1, &vex2, &weight);
	}
}

/**
  * @brief  ��ͼ�Ľṹ��ʾ����,�����ʽΪ�㣬 �㣬 Ȩֵ
  * @param[in]   graphMatrix    ͼ
  */
void WriteGraph(GraphMatrix* graphMatrix)
{
	int i, j;

	printf("ͼ�Ľṹ���£������ʽΪ�� ���� ��Ȩֵ\n");
	for (i=0;i<graphMatrix->size; i++)
	{
		for (j=0; j<graphMatrix->size; j++)
		{
			if (graphMatrix->graph[i][j] < INT_MAX)
			{
				printf("%d,%d,%d\n", i, j, graphMatrix->graph[i][j]);
			}
		}
	}
}


/**
  * @brief  ͼ��������ȱ����ݹ��㷨���ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */
void DFS(GraphMatrix* graphMatrix, int * visited, int i)
{
	int j;
	visited[i] = 1;
	printf("%c",graphMatrix->vex[i]);//�Ҷ����±�����ֵ

	for(j = 0; j < graphMatrix->size; j++)
	{
		if(graphMatrix->graph[i][j] != INT_MAX && !visited[j])
			DFS(graphMatrix, visited, j);
	}
}

/**
  * @brief  ��ȱ������ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  */
void DFSGraphMatrix(GraphMatrix* graphMatrix)//���Ϊ�������Ϊ��
{
	int i;
	/** ���ڼ�¼ͼ����Щ����Ѿ��������� */
	int *visited = (int*)malloc(sizeof(int) * graphMatrix->size);

	/** ��ʼ��Ϊ�㶼û�б����� */
	for(i = 0; i < graphMatrix->size; i++)
		visited[i] = 0;

	for(i = 0; i < graphMatrix->size; i++)
		if(!visited[i]) /* ��δ���ʹ��Ķ������DFS��������ͨͼ��ֻ��ִ��һ�� */
			DFS(graphMatrix, visited, i);
}


/**
  * @brief  ͼ�Ĺ�����ȱ����ݹ��㷨���ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  * @param[in]   visited    ����ǵģ����õ��Ƿ񱻷��ʣ�һά����
  * @param[in]   i    �����
  */
void BFS(GraphMatrix* graphMatrix, int * visited, int i)
{

}

/**
  * @brief  ͼ�Ĺ�����ȱ������ڽӾ����ʾͼ
  * @param[in]   graphMatrix    ͼ
  */
void BFSGraphMatrix(GraphMatrix* graphMatrix)
{

}
