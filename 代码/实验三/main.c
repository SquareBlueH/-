#include <stdio.h>
#include <stdlib.h>
#include "linkstack.h"

int main()
{
    char str[20],x;
    LinkStack stack1;
    int i;
    stack1=SetNullStack_Link();
    printf("��ʾ������0������");
    printf("\n�������ַ����飺");
    i=0;//��һ����ջ
    while(scanf("%s",str)){
    if(str[1]=='\0')
    {
    printf("���������%s������Ϊֹ\n",str);break;}
            else
    i=0;
    while(str[i]!='\0')
    {
        Push_link(stack1,str[i]);
        i++;
    }//ʵ�ִ�������
    i=0;
    while(str[i]!='\0'){
            x=Top_link(stack1);
            if(str[i]!=x)break;
            i++;
            Push_link(stack1,str[i]);
    }
    if(str[i]!='\0')
        printf("�����%s���飬���ǻ���\n",str);
    else printf("����%s���飬�ǻ�������\n",str);
    }
    return 0;
}
