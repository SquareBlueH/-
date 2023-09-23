/**
* @file graphmatrixutil.c
* @brief 图的邻接矩阵表示以及辅助函数
*/


#include <stdlib.h>
#include <stdio.h>
#include "LinkQueue.h"
#include "graphmatrix.h"
/**
  * @brief  初始化图
  * @param[in]   num    图中结点的个数
  * @return    用邻接矩阵表示的图
  */
GraphMatrix* InitGraph(int num)//初始化
{
	int i;
	int j;
	GraphMatrix* graphMatrix = (GraphMatrix*)malloc(sizeof(GraphMatrix));
	/** 图中结点的个数 */
	graphMatrix->size = num;
    graphMatrix->vex = (char*)malloc(sizeof(char) * graphMatrix->size);
	/** 给图分配空间 */
	graphMatrix->graph = (int**)malloc(sizeof(int*) * graphMatrix->size);
	for (i=0;i<graphMatrix->size;i++)
	{
		graphMatrix->graph[i] = (int*)malloc(sizeof(int) * graphMatrix->size);
	}

	/** 给图中所有元素设置初值 */
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
  * @brief  将数据读入图中,方式为点 点  权值，如果输入的权值为0，则输入结束
  * @param[in]   graphMatrix    图
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
	printf("请输入定点值，输入方式为：顶点回车\n");
    for(i=0;i<graphMatrix->size;i++)
    {
        scanf("%c",&graphMatrix->vex[i]);
        fflush(stdin);
    }
	/** 输入方式为点 点 权值，权值为0，则输入结束 */
	printf("请输入，输入方式为点,点,权值，权值为0，则输入结束\n");
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
  * @brief  将图的结构显示出来,输出方式为点， 点， 权值
  * @param[in]   graphMatrix    图
  */
void WriteGraph(GraphMatrix* graphMatrix)
{
	int i, j;

	printf("图的结构如下，输出方式为点 ，点 ，权值\n");
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
  * @brief  图的深度优先遍历递归算法，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  * @param[in]   visited    做标记的（设置点是否被访问）一维数组
  * @param[in]   i    结点编号
  */
void DFS(GraphMatrix* graphMatrix, int * visited, int i)
{
	int j;
	visited[i] = 1;
	printf("%c",graphMatrix->vex[i]);//找顶点下标找数值

	for(j = 0; j < graphMatrix->size; j++)
	{
		if(graphMatrix->graph[i][j] != INT_MAX && !visited[j])
			DFS(graphMatrix, visited, j);
	}
}

/**
  * @brief  深度遍历，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  */
void DFSGraphMatrix(GraphMatrix* graphMatrix)//这个为主上面的为辅
{
	int i;
	/** 用于记录图中哪些结点已经被访问了 */
	int *visited = (int*)malloc(sizeof(int) * graphMatrix->size);

	/** 初始化为点都没有被访问 */
	for(i = 0; i < graphMatrix->size; i++)
		visited[i] = 0;

	for(i = 0; i < graphMatrix->size; i++)
		if(!visited[i]) /* 对未访问过的顶点调用DFS，若是连通图，只会执行一次 */
			DFS(graphMatrix, visited, i);
}


/**
  * @brief  图的广度优先遍历递归算法，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  * @param[in]   visited    做标记的（设置点是否被访问）一维数组
  * @param[in]   i    结点编号
  */
void BFS(GraphMatrix* graphMatrix, int * visited, int i)
{

}

/**
  * @brief  图的广度优先遍历，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  */
void BFSGraphMatrix(GraphMatrix* graphMatrix)
{

}
