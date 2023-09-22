package work2;

public class    java5 {
    public static void main(String[] args){
        //食用方法：在Run命令界面中，点击左下角扳手，alt+r界面中输入数字
        double area=0;
        switch (args.length){
            case 1: area=getArea(Double.parseDouble(args[0]));
                System.out.println("半径10的圆面积");
                break;
            case 2: area=getArea(Double.parseDouble(args[0]),
                    Double.parseDouble(args[1]));
                System.out.println("长：2；宽：3的矩形面积");
                break;
            case 3: area=getArea(Double.parseDouble(args[0]),
                    Double.parseDouble(args[1]),
                   Double.parseDouble(args[2]));
                System.out.println("上底：3；下底：4；高：10的梯形面积");
                break;

        }
            System.out.print("结果:"+area);
    }
    /*圆面积*/public static double getArea(double r){

        return r*r*3.14;
    }
    /*矩形面积*/public static double getArea(double a,double b){

        return a*b;
    }
    /*梯形面积*/public static double getArea(double a,double b,double h){

        return (a+b)*h/2;
    }
}
