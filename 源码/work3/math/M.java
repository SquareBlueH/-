package work3.t1;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        double sideA,sideB,sideC,area;
        System.out.println("请输入三边长度");
        Scanner s=new Scanner(System.in);
        sideA=s.nextDouble();
        sideB=s.nextDouble();
        sideC=s.nextDouble();
        Trangle trangle=new Trangle(sideA,sideB,sideC);
        area=trangle.getArea();
        if(area>0)
            System.out.println("是三角形，面积为"+area);
        else System.out.println("不是三角形");

        System.out.println("请输入三边长度");
        sideA=s.nextDouble();
        sideB=s.nextDouble();
        sideC=s.nextDouble();
        trangle.setLength(sideA,sideB,sideC);
        area=trangle.getArea();
        if(area>0)
            System.out.println("是三角形，面积为"+area);
        else System.out.println("不是三角形");
    }
}