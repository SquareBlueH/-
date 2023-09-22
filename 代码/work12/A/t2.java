package changep;

// Bank. java
class Bank implements Runnable {
    int money = 100;//共享数据         //[代码1]     // 声明一个int类型变量money，初值为100
    Thread zhang, keven;
    Bank() {
        zhang = new Thread(this, "会记");//创建zhang，Bank对象为zhang的目标对象
        //zhang.setName("会记");//设置zhang线程的名字为"会计”
        keven = new Thread(this, "出纳");//创建keven,Bank对象为keven的目标对象
        //keven.setName("出纳");//设置keven线程的名字为"出纳"
    }

    public void run() {
        int i = 0;//不共享, money=100; // 声明一个int类型变量i，初值为0
        while (true) {
            if (Thread.currentThread() == zhang) // 判断线程zhang是否正在占有CPU资源
            {
                i = i + 1;
                money = money + 1;
                System.out.printf("\n%s将money的值改为%d\t", zhang.getName(), money);
                System.out.printf("%s的局部变量i=%d\n", zhang.getName(), i);
                if (i >= 6) {
                    System.out.printf("%s线程进入死亡状态\n", zhang.getName());
                    return;// 使得线程zhang进入死亡状态
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            } else if (Thread.currentThread() == keven) //判断线程keven是否正在占有CPU资源
            {
                i = i - 1;
                money = money - 1;
                System.out.printf("\n%s将money的值改为%d\t", keven.getName(), money);
                System.out.printf("%s的局部变量i=%d\n", keven.getName(), i);
                if (i <= -6) {
                    System.out.printf("%s线程进入死亡状态\n", keven.getName());
                    return;// 使得线程keven进入死亡状态
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
 // BankExample. java
 public class t2 {
    public static void main(String args[]) {
        Bank bank = new Bank();
        bank.zhang.start();
        bank.keven.start();
    }
}