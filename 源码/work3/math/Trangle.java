package work3.t1;

import static java.lang.Math.sqrt;

public class Trangle {
    double sideA,sideB,sideC;
    boolean bool;

    public Trangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;//生成三边构造方法

        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA)
            bool=true;
        else bool=false;
    }
    public double getArea(){
        double area=0;
        if(bool){
            double p=(sideA+sideB+sideC)/2;
            area=sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));//海伦公式s= Vp(p-a)(p-b)(p-c)  其中p=(a+b+c)/2

        }
        else area=-1;
            return area;
    }
    public void setLength(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;//生成三边构造方法

        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA)
            bool=true;
        else bool=false;
        }
}