package work4.p;

public class java {

    public static void main(String[] args) {
        System.out.println("a类是A1, A2. A3的父类，用a类对象a调用子类方法");
        System.out.println("\n创建a1对象,用它的上转型对象a调用它方法");
        A a = new A1();
        a.f(10);
        a.g(12, 20);
        System.out.println(a.h(100.0D));
        System.out.println("\n创建A2对象,用它的上转型对象a调用它方法");
        a = new A2();
        a.f(10);
        a.g(12, 20);
        System.out.println(a.h(100.0D));
        System.out.println("\n创建A3对象,用它的上转型对象a调用它方法");
        a = new A3();
        a.f(10);
        a.g(12, 20);
        System.out.println(a.h(100.0D));
    }
}