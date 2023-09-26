package work2;
import java. util. Scanner;
public class java3 {
    public static void main(String[] args) {
        char[][] ts = new char[4][7];
        Scanner reader = new Scanner(System.in);
        String str;
        System.out.println("输入诗句: ");
        for (int i = 0; i < ts.length; i++) {
            str = reader.nextLine(); //      键盘按输入一行字符串
            ts[i] = str.toCharArray(); //    字符串转成字符数组
        }
        System.out.println("\n藏头: ");
        for (int i = 0; i < ts.length; i++) {
            for (int j = 0; j < ts[i].length; j++)
//如果列号为0,即为首字,则输出该元素
                if (j == 0) System.out.print(ts[i][j] + " ");
        }
        System.out.println("\n藏尾: ");
        for (int i = 0; i < ts.length; i++) {
            for (int j = 0; j < ts[i].length; j++)
//如果列号为行总长度减一,即为尾字，则输出该元素
                if (j == ts[i].length- 1) System.out.print(ts[i][j] + " ");
        }
    }
}