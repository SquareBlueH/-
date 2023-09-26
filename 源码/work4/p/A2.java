package work4.p;

    public class A2 extends A {
        public A2() {
        }

        public void f(int x) {
            System.out.println("Hello:" + x);
        }

        public void g(int x, int y) {
            System.out.println(x - y);
        }

        public double h(double x) {
            return Math.sqrt(x);
        }
    }