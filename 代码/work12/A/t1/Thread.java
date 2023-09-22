package changep.t1;
class Tortoise extends Thread {                 // 乌龟类
    final t1 t1 =new t1();
    int sleepTime = 0, liveLength = 0;          //成员变量
    Tortoise(int sleepTime, String name, int liveLength) { //构造 方法
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
        setName(name);//[代码1]//设置线程的名字为name
    }
        public void run () {
            while (true) {//参考Example3_3的程序完成这里代码
                          liveLength--;//1)liveLength碱少1，并打印出对应的 @到屏幕中表示乌龟跑的距离，
                System.out.print("@");
                try{                    //2)调用sleep (SleepTime) ，让 乌龟休息一小会sleepTime毫秒，
                    sleep(sleepTime);
                }catch (InterruptedException e){}
                if(liveLength==0){
                    System.out.println("乌龟跑到终点");
                return;}
                                    //3)如果乌龟liveLength小于0，则乌龟就停止跑,和信息打印,从而退出run方法*/
                                    //[代码2]
            }
        }
    }
    class Rabbit extends Thread {       //兔子类
        int sleepTime = 0, liveLength;
        //成员变量
        Rabbit(int sleepTime, String name, int liveLength) { //构造 方法
            this.sleepTime = sleepTime;
            this.liveLength = liveLength;
            setName(name);//[代码1]//设置线程的名字为name
        }

        public void run() {
            while (true) {
            /*参考Example3_3 的程序完成这里代码l
            1)liveLength减少1，并打印出对应的*到屏幕中表示兔子跑的距离，
            2)调用sleep (sleepTime) ，让兔子休 息一小会sleepTime毫秒，
            3)如果兔子 liveLength 小于o，则兔子就停止跑步，和信息打印，从而退出run方法
            */
                liveLength--;
                System.out.print("*");
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) { }
                if (liveLength ==0){
                    System.out.println("兔子跑到终点");
                return;}
                //[代码2]
            }
        }
}

