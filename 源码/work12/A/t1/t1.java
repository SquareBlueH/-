package changep.t1;

public class t1 {
    public static void main(String args[]) {
        Rabbit rabbit = new Rabbit(200, "兔子", 50); // 创建新建线程rabbit ;
        Tortoise tortoise = new Tortoise(100, "乌龟", 50); //创建新建线程tortoise
        tortoise.start();//[代码1] //启动线程tortoise
        rabbit.start();//[代码2]//启动线程rabbit
    }
}