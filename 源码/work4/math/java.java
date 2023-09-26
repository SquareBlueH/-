package work4.work;


public class java {
    public java() {
    }

    public static void main(String[] args) {
        A a = new A1();
        a.f(10);
        a.g(12, 20);
        System.out.println("调用h方法，传入整数的平方为：" + a.h(100.0D));
    }
}
