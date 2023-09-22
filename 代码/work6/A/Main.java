package WORK.work6.A;
import java. util. *;
import java. text. *;
public class Main {
    public static void main(String args[]) {
        Date date = new Date();
        int year, month, day;
        Scanner read = new Scanner(System.in);
        System.out.println("输入一个日期:");
        year = read.nextInt();                                                               //[代码1]; //输入年
        month = read.nextInt();                                                              //[代码2] ;//输入月
        day = read.nextInt();                                                              //[代码3] ;//输入日
        Calendar cd = Calendar.getInstance();                                     //使用getInstance ()定义Calendar实例
        cd.set(year+0, month-1, day+0);                                                          //设置Calendar的年月日，月数要减1
        DateFormat sf = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);          //定义一个短日期格式
        DateFormat mf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);        //定义一个中日期格式
        DateFormat lf = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);            //定义一个长日期格式--
        DateFormat ff = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);        //定义一个满日期格式--
        SimpleDateFormat spf = new SimpleDateFormat("北京时间：yyyy年MM月dd日\nHH小时m分钟s秒S毫秒");                                                 //自定义一一个简单日期格式
        System.out.println((cd.getTime()));                                                                        //输出默认时间格式
        System.out.println(sf.format(date));                                                     //输出短时间格式
        System.out.println(mf.format(new Date()));                                             //输出中时间格式
        System.out.println(lf.format(cd.getTime()));                                             //输出长时间格式
        System.out.println(ff.format(cd.getTime()));                                                                 //输出满时间格式
        System.out.println(spf.format(cd.getTime()));//输出自定义时间格式
    }
}