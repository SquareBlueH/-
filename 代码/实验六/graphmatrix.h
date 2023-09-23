
#ifndef GRAPHMATRIXUTIL_H_
#define GRAPHMATRIXUTIL_H_
#define INT_MAX 10000
/**
 * @brief 图的邻接矩阵表示
 */
typedef struct	GRAPHMATRIX_STRU
{
    char*vex;//存abcdef第一项
	int size;/*!< 图中结点的个数 */
	int **graph;/*!<二维数组保存图 */
}GraphMatrix;

/**
  * @brief  初始化图
  * @param[in]   num    图中结点的个数
  * @return    用邻接矩阵表示的图
  */

GraphMatrix* InitGraph(int num);

/**
  * @brief  将数据读入图中
  * @param[in]   graphMatrix    图
  */

int LocateVexM(GraphMatrix *G,char v);

void ReadGraph(GraphMatrix* graphMatrix);

/**
  * @brief  将图的结构显示出来
  * @param[in]   graphMatrix    图
  */
void WriteGraph(GraphMatrix* graphMatrix);
/**
  * @brief  图的深度优先遍历递归算法，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  * @param[in]   visited    做标记的（设置点是否被访问）一维数组
  * @param[in]   i    结点编号
  */
void DFS(GraphMatrix* graphMatrix, int * visited, int i);

/**
  * @brief  深度遍历，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  */
void DFSGraphMatrix(GraphMatrix* graphMatrix);

/**
  * @brief  图的广度优先遍历递归算法，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  * @param[in]   visited    做标记的（设置点是否被访问）一维数组
  * @param[in]   i    结点编号
  */
void BFS(GraphMatrix* graphMatrix, int * visited, int i);

/**
  * @brief  图的广度优先遍历，邻接矩阵表示图
  * @param[in]   graphMatrix    图
  */
void BFSGraphMatrix(GraphMatrix* graphMatrix);
#endif

