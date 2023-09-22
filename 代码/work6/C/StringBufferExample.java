package WORK.work6.C;
class StringBufferExample {
    public static void main(String args[]) {
        StringBuffer str= new StringBuffer("ABCDEFG");
        str.append("123456789");                                                             // [代码1] // 向str尾加“123456789"。
        System.out. println(str);
        str.replace(1,2,"b");                                                           //[代码2]//将str中的字符'B'替换为'b'
        System.out.println(str);
        str.insert(6,"Game");                                           //[代码3]//在str中的“123456789”前面插入“Game”
        System.out.println(str);
        int index=str.indexOf("1",1);                               //[代码4] // 获取str中首次出现“1”的位置。
        str.delete(11,15);                                                           //[代码5]//删除str中“1234”。
        int n=str.length();                                                     //[代码6]获取str中字符个数
        str.replace(13,16,"七八九");                                                   // [代码7]//将str中“789”替换为“七八九”。
        System.out. println(str);
    }
}
