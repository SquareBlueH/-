package A;
import java.util.Random;
class Poker<C, P> {//定义泛型类Poker
    C c;
    P p;
    Poker(C c,P p){
        //构造方法初始化
        this.c=c;
        this.p=p;
    }
    public String gets(){
        return c.toString()+p.toString();//返回C和P的两个toString()组合
    }
}
class Color {
        @Override
        public String toString(){ //重写toString()
        String str;
        Random r = new Random();
        int i= r.nextInt(4)+1; //随机生成1到4的整数
        switch(i)//选择初始化花色
        {
            case 1: str="黑桃";break;
            case 2: str="方片";break;
            case 3: str="梅花";break;
            case 4: str="红心";break;
            default: str=toString();break;
        }
        return str;
    }
}
class Point {
        @Override
        public String toString(){ //重写toString()
        String str;
        Random r = new Random();
        int i=r.nextInt(13)+1;//随机生成1到13的整数
        switch(i)//选择初始化点数
        {
            /*case 1: str="1";break;
            case 2: str="2";break;
            case 3: str="3";break;
            case 4: str="4";break;
            case 5: str="5";break;
            case 6: str="6";break;
            case 7: str="7";break;
            case 8: str="8";break;
            case 9: str="9";break;
            case 10: str="10";break;*/
            case 11: str="J";break;
            case 12: str="Q";break;
            case 13: str="K";break;
            default: str=String.valueOf(i);break;//i转成字符串
        }
        return str;
    }
}
public class t1 {
    public static void main(String[] args) {
        Color color = new Color();
        Point point = new Point();
        Poker<Color,Point> s=new Poker<Color,Point>(color,point);
        //声明 Poker泛型，并使用color和point初始化
        for (int i = 1; i <= 5; i++)
            System.out.println("随机生成：" +s.gets());//生成并打印出一张牌
        }
    }