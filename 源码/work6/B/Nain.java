package WORK.work6.B;
import java. util. Scanner ;
import java. util. regex. *;
public class Nain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System. in);
        System.out. println("请输入你的身份证号: ");
        String temp = s.nextLine();          //[代码] ; // 输入一行字符串
                //身份证号正则表达式
        Pattern p1=Pattern. compile("(^\\d{18}$)|(^\\d{17}[Xx]$)") ;
        Matcher m=p1.matcher(temp) ;
        if(m.matches())
            System.out. println("输入身份证号合法");
        else
            System.out. println("输入身份证号错误! ");
        System.out. println("请输入你的邮箱: ");
        temp = s.nextLine();                //[代码] ; //输入一行字符串
                //邮箱正则表达式
                Pattern p2=Pattern. compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") ;
        m=p2.matcher (temp) ;
        if(m.matches())
            System.out.println("输入邮箱正确");
        else
            System. out. println("输入邮箱错误! ");
    }
}
