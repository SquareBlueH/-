/**
* @file graphlistutil.c
* @brief 图的邻接表表示以及辅助函数
*/

#include <stdlib.h>
#include <stdio.h>
#include "LinkQueue.h"
#include "graphlist.h"
/**
  * @brief  初始化图
  * @param[in]   num    图中结点的个数
  * @return    用邻接表表示的图
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
  * @brief  将数据读入图中
  * @param[in]   graphList    图
  */
void ReadGraph(GraphList* graphList)
{
	int vex1, vex2;
	GraphListNode *tempNode = NULL;
	/** 输入方式为点 点 ，点为-1，则输入结束 */
	printf("请输入，输入方式为点 点 ，点为-1，则输入结束\n");
	scanf("%d%d", &vex1, &vex2);

	while(vex1>=0 && vex2>=0)
	{
		tempNode = (GraphListNode*)malloc(sizeof(GraphListNode));
		tempNode->nodeno = vex2;
		tempNode->next = NULL;

		/**寻找到要插入结点的地方，这里为了方便就放在头部*/
		tempNode->next = graphList->graphListArray[vex1].next;
		graphList->graphListArray[vex1].next = tempNode;
		scanf("%d%d", &vex1, &vex2);
	}
}

/**
  * @brief  将图的结构显示出来
  * @param[in]   graphList    图
  */
void WriteGraph(GraphList* graphList)
{
	int i;
	GraphListNode *tempNode = NULL;

	for (i=0; i<graphList->size; i++)
	{
		/**输出每条链表的结点*/
		tempNode = graphList->graphListArray[i].next;

		while(tempNode != NULL)
		{
			printf("结点%d和%d相连\n",i,tempNode->nodeno);
			tempNode = tempNode->next;
		}
	}
}


/**
  * @brief  图的深度优先遍历递归算法，邻接表表示图
  * @param[in]   graphList    图
  * @param[in]   visited    做标记的（设置点是否被访问）一维数组
  * @param[in]   i    结点编号
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
  * @brief  深度遍历，邻接表表示图
  * @param[in]   graphList    图
  */
void DFSGraphList(GraphList* graphList)
{
	int i;
	/** 用于记录图中哪些结点已经被访问了 */
	int *visited = (int*)malloc(sizeof(int) * graphList->size);

	/** 初始化为点都没有被访问 */
	for(i = 0; i < graphList->size; i++)
		visited[i] = 0;

	for(i = 0; i < graphList->size; i++)
		if(!visited[i]) /* 对未访问过的顶点调用DFS，若是连通图，只会执行一次 */
			DFS(graphList, visited, i);
}

/**
  * @brief  图的广度优先遍历递归算法，邻接表表示图
  * @param[in]   graphList    图
  * @param[in]   visited    做标记的（设置点是否被访问）一维数组
  * @param[in]   i    结点编号
  */
void BFS(GraphList* graphList, int * visited, int i)
{
	int tempVex;
	GraphListNode *tempNode = NULL;
	/** 广度优先遍历使用的队列是c++的STL中的queue */
	LinkQueue waitingQueue = NULL;
	waitingQueue = SetNullQueue_Link();

	/** 如果没有访问过，则访问 */
	if (!visited[i])
	{
		/** 设置标记，表明已经被访问 */
		visited[i] = 1;
		/** 输出访问的结点编号 */
		printf("%d ", i);
		/** 将刚访问的结点放入队列 */
		EnQueue_link(waitingQueue,i);

		/** 访问结点－广度优先 */
		while(!IsNullQueue_Link(waitingQueue))
		{
			tempVex = FrontQueue_link(waitingQueue);
			DeQueue_link(waitingQueue);

			/**依次访问与当前结点相邻的点*/
			tempNode = graphList->graphListArray[tempVex].next;
			while(tempNode != NULL)
			{
				/**如果其它顶点与当前顶点存在边且未访问过  */
				if(!visited[tempNode->nodeno])
				{
					/**做标记*/
					visited[tempNode->nodeno] = 1;
					/**入队*/
					EnQueue_link(waitingQueue, tempNode->nodeno);
					/**输出*/
					printf("%d ", tempNode->nodeno);

				} //end if(!visited[tempNode->nodeno])
				/**移动到下一个结点*/
				tempNode = tempNode->next;
			} //end while(tempNode != NULL)
		}//end while(!waitingQueue.empty())
	}//end if (!visited[i])
}


/**
  * @brief  图的广度优先遍历，邻接表表示图
  * @param[in]   graphList    图
  */
void BFSGraphList(GraphList* graphList)
{
	int i;

	/** 用于记录图中哪些结点已经被访问了 */
	int *visited = (int*)malloc(sizeof(int) * graphList->size);

	/** 设置所有结点都没有被访问，其中1为访问过，0为没有被访问 */
	for(i = 0; i < graphList->size; i++)
		visited[i] = 0;

	/** 从0号结点开始进行广度优先遍历 */
	for(i = 0; i < graphList->size; i++)
	{
		BFS(graphList, visited, i);
	}//end for(i = 0; i < graphList->size; i++)
}
