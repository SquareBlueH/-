package work4.Math;
import java.io.PrintStream;

public class M {
    public M() {
    }

    public static void main(String[] args) {
        ComputeSales[] goods = new ComputeSales[20];
        int total = (int)(Math.random() * 21.0D);

        for(int i = 0; i < total; ++i) {
            int temp = (int)(Math.random() * 3.0D);
            if (temp == 0) {
                goods[i] = new TV();
                System.out.println("商店销售出一台电视机：3000");
            } else if (temp == 1) {
                goods[i] = new Computer();
                System.out.println("商店销售出一台电脑：10000");
            } else if (temp == 2) {
                goods[i] = new Mobile();
                System.out.println("商店销售出一台手机：1000");
            }
        }

        Shop shop = new Shop(goods);
        System.out.println("今天商店销售电器总数为：" + total);
        PrintStream var10000 = System.out;
        double var10001 = shop.getTotalSales(total);
        var10000.println("今天商店销售额：" + var10001);
    }
}