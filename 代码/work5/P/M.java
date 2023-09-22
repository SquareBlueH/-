import java. util. Scanner ;
public class M {
    public static void main(String[] args) {
        double a;
        int[] array = new int[2];
        Scanner scanner = new Scanner(System.in);
                    //捕捉输入格式异常.
                try {
                System.out.println("输入数字:");
                 a=scanner.nextDouble();
                   // [代码] //键盘敲入一个double数赋值给a
        }
                    catch(Exception e) {
                System.out.println("输入数字格式不匹配异常! " +e);
                   // [代码] //输出异常追踪信息
        }//捕捉数组溢出异常
                try {
                    array = new int[8];
                    //[代码] //假设给下标为2的数组元素赋值为8
                }
                catch(Exception e){
                System.out.println("数组溢出异常! "+e);
                        //[代码]//输出异常追踪信息
        }
    }
}