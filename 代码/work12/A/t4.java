package changep;

class Shop implements Runnable {
    Thread zhangWorker, wangWorker, boss;
    Shop() {
        boss = new Thread(this);
        zhangWorker = new Thread(this);
        wangWorker = new Thread(this);
        zhangWorker.setName("勤干的张工");
        wangWorker.setName("勤俭的王工");
        boss.setName("整蛊的李老板");
    }
    public void run() {
        int i = 0;
        int j = 0;
        if (Thread.currentThread() == zhangWorker) {// 若当前线程是zhangWorker
            while (true) {
                try {
                    i++;
                    System.out.printf("%s已搬运了%d箱苹果\n",zhangWorker.getName(),i);//输出谁搬了几箱苹果
                    if (i == 5)
                        return;//搬够5箱苹果完工。
                    Thread.sleep(10000);       // zhangWorker休眠10秒（10000毫秒）
                } catch (InterruptedException e) {
                    System.out.println(boss.getName() + "让" + "张工" + "继续工作!\n");
                }
            }
        } else if (Thread.currentThread() == wangWorker) {
            // 若当前线程是wangWorker
            while (true) {
                try {
                    j++;
                    System.out.printf("%s已搬运了%d箱苹果\n",wangWorker.getName(),j);//输出谁搬了几箱苹果

                    if (j == 5)
                        return;//搬够5箱苹果完工。
                    Thread.sleep(100000);       // wangWorker休眠10秒（10000毫秒）
                } catch (InterruptedException e) {
                    System.out.print(boss.getName() + "让" + "王工" + "继续工作!\n");
                }
            }
        } else if (Thread.currentThread() == boss) {
            while (true) {
                zhangWorker.interrupt();     // 吵醒zhangWorker
                wangWorker.interrupt();
                if (!(zhangWorker.isAlive()||wangWorker.isAlive())) {// 若两位工人都搬完了
                    System.out.println("吊毛老板" + "说：下班吧！");   // 老板说下班
                    return;
                }
            }
        }
    }
}

public class t4 {
    public static void main (String args[]){
        Shop shop= new Shop();
        shop.zhangWorker.start();         // 开始张工线程
        shop.wangWorker.start();        // 开始王工线程
        shop.boss.start();       // 开始老板线程
    }
}