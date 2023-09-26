package work3.MOMN;

public class A {
    private  float a;
    private static float b;//private 为私有变量

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public static float getB() {
        return b;
    }

    public static void setB(float b) {
        A.b = b;
    }
    public void printA(){
        System.out.println(a);
    }
    public  static void printB(){
        System.out.println(b);
    }
}
