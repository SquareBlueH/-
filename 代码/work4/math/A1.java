package work4.work;


public class A1 implements A {
    public A1() {
    }

    public void f(int x) {
        System.out.println("调用f方法，传入整数为：" + x);
    }

    public void g(int x, int y) {
        System.out.println("调用f方法，传入两个整数之和为：" + x + y);
    }

    public double h(double x) {
        return x * x;
    }
}