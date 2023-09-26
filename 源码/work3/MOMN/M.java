package work3.MOMN;

public class M {
    public static void main(String[] args){
        A.setB(100);
        A.printB();

        A boss=new A();
        A staff=new A();
        boss.setA(200);
        A.setB(300);
        staff.setA(400);
        A.setB(900);

        boss.printA();
        A.printB();
        staff.printA();
        A.printB();
    }
}