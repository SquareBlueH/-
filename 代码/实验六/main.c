#include <stdio.h>
#include <stdlib.h>
#include"graphmatrix.h"

int main()
{
    GraphMatrix*g;
    g=InitGraph(6);//申请全部的空间
    ReadGraph(g);//完成顶点的输入和边的输入
    printf("深度优先遍历：");
    WriteGraph(g);
    DFSGraphMatrix(g);//深度遍历的结果

    printf("\nHello world!\n");
    return 0;2

}
