package A;

class JoinThread  implements Runnable {
    Thread 运货司机,装运工,仓库管理员;
    String[] step ={"开始打开车锁","准备把握方向盘","接着挂挡","然后踩油门","最后开车"};
    JoinThread() {
        运货司机=new Thread(this);    // 初始化运货司机
        装运工=new Thread(this);    // 初始化装运工
        仓库管理员=new Thread(this);    // 仓库管理员
        运货司机.setName("运货司机");
        装运工.setName("装运工");
        仓库管理员.setName("仓库管理员");
    }
    public void run(){
        if(Thread.currentThread()==运货司机) {// 若为运货司机
            System.out.println(运货司机.getName()+"要等"+装运工.getName()+"搬货");
            try{
                装运工.join();    // 占有CPU资源期间联合线程：装运工
            }
            catch(InterruptedException e) { }
            for(int i=0;i<step.length;i++) {
                System.out.println(运货司机.getName()+step[i]); //输出货运司机的开车步骤
                try{
                    Thread.sleep(500);// 休息0.5秒

                }
                catch(InterruptedException ee) { }

            }
        }
       else if(Thread.currentThread()==装运工) {// 若为装运工

            System.out.println(装运工.getName() +"要等"+仓库管理员.getName()+"开门");

            try{
                仓库管理员.join();   // 占有CPU资源期间联合线程：仓库管理员
            }
            catch(InterruptedException e) { }


            for(int i=1;i<=10;i++) {
                System.out.println(装运工.getName()+"搬运第"+i+"箱货物到货车");
                try{
                        Thread.sleep(500);// 休息0.5秒
                }
                catch(InterruptedException ee) { }
            }
        }
       else if(Thread.currentThread()==仓库管理员) { // 若为仓库管理员

            for(int i=1;i<=5;i++) {
                System.out.println(仓库管理员.getName()+"打开第"+i+"道门") ;
                try{
                        Thread.sleep(500);    // 休息0.5秒
                }
                catch(InterruptedException e) { }
            }
        }
    }
}
public class t6{
    public static void main(String args[ ]) {
        JoinThread JoinThread = new JoinThread(); // 初始化联合线程类
        JoinThread.运货司机.start();  // 货运司机开始开车
        JoinThread.装运工.start();   // 装运工开始搬货
        JoinThread.仓库管理员.start();// 仓库管理员开始开门
    }
}
