package WORK.work6.B;

import java. util.*;
public class JION {
    public static void main(String[] args) {
        System.out.println("输入字符串: ");
        Scanner reader = new Scanner(System.in);
        String str = reader.nextLine();
        Scanner scanner = new Scanner(str);
        double sum = 0;
                //以非数字作为分隔符
        scanner.useDelimiter(" [^0-9.]+");
        while (scanner.hasNextDouble()) {
            sum += scanner.nextDouble();        //[代码];//统计数字之和
        }
        System.out.println("字符串中所有数字和为: " + sum);
    }//     apple 8 pear 6.5 pitch 10 banana 5.8
}
