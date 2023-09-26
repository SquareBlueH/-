package work2;
import java. util. Scanner;
public class java1 {
    public static void main
            (String[] args) {
        System.out.println("请输入两个数，能被3和7同时整除的整数");
        Scanner one = new Scanner(System.in);
        int sum = 0, i;
        int m = one.nextInt();//给 予的值调换
        int n = one.nextInt();
        System.out.println("获得的数组");
        for (i = m; i <= n; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                System.out.print(i + "     ");
                sum += i;
            }
            if (i % (5 * 3 * 7) == 0) {//换行 目的需要的值相乘再算行单
                System.out.print("\n");
            }
        }
                System.out.println("\n得到的数组之和为:" + sum);
                System.out.println("某某某");
    }
}