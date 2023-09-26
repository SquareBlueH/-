package work4.p;

public class A3 extends A {
    public A3() {
    }

    public void f(int x) {
        System.out.println(x);
    }

    public void g(int x, int y) {
        System.out.println(1.0D * (double)x / (double)y);
    }

    public double h(double x) {
        System.out.println("你好：" + x);
        return 1.0D / x;
    }
}
