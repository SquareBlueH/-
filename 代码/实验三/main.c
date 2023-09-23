#include <stdio.h>
#include <stdlib.h>
#include "linkstack.h"

int main()
{
    char str[20],x;
    LinkStack stack1;
    int i;
    stack1=SetNullStack_Link();
    printf("提示：输入0即结束");
    printf("\n请输入字符数组：");
    i=0;//第一步入栈
    while(scanf("%s",str)){
    if(str[1]=='\0')
    {
    printf("输出结束语%s，到此为止\n",str);break;}
            else
    i=0;
    while(str[i]!='\0')
    {
        Push_link(stack1,str[i]);
        i++;
    }//实现从左往右
    i=0;
    while(str[i]!='\0'){
            x=Top_link(stack1);
            if(str[i]!=x)break;
            i++;
            Push_link(stack1,str[i]);
    }
    if(str[i]!='\0')
        printf("输入的%s数组，不是回文\n",str);
    else printf("输入%s数组，是回文内容\n",str);
    }
    return 0;
}
