#include <stdio.h>
#include <stdlib.h>
#include"graphmatrix.h"

int main()
{
    GraphMatrix*g;
    g=InitGraph(6);//����ȫ���Ŀռ�
    ReadGraph(g);//��ɶ��������ͱߵ�����
    printf("������ȱ�����");
    WriteGraph(g);
    DFSGraphMatrix(g);//��ȱ����Ľ��

    printf("\nHello world!\n");
    return 0;2

}
