package work4.Math;

public class Shop {
    ComputeSales[] goods;
    double totalSales = 0.0D;

    public Shop(ComputeSales[] goods) {
        this.goods = goods;
    }

    public double getTotalSales(int n) {
        for(int i = 0; i < n; ++i) {
            this.totalSales += this.goods[i].sales();
        }

        return this.totalSales;
    }
}