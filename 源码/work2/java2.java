package work2;
import java. util.*;
public class java2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] A =new int [20] ; //初始化20个整数空间
        int[] B =new int [10] ; //初始化10个 整数空间

        System. out. println("随机生成20个整数放入数组A中: ");

        for (int i=0;i<20;i++){
            A[i] =r.nextInt(100)  ; //随机生成一个100以内的整数
            System. out. print(A[i]+" ");
        }
        System. out. println();
        System. out. println("将数组A的后10个整数复制到数组B中: ");
        System. arraycopy(A,10,B,0,10);

        for (int i=0;i<B. length;i++) System. out. print (B[i]+"" );
        System. out. println() ;

        System.out. println("将数组B升序排序: ");
        Arrays.sort(B) ;//升序调用sort方法

        for (int i=0;i<B. length; i++)System. out. print(B[i]+"" );
        System. out. println();

        Scanner reader=new Scanner (System. in);
        System. out. println("输入要查找的数: ");
        int num = reader. nextInt() ;
        System. out. println("使用二叉查找法在数组B中查找"+num);
        int index=Arrays.binarySearch(B,num);
        if (index>-1)System. out. println(num+"的下标是: "+index);
        else System. out. println (num+"不在数组B中");
    }
}
