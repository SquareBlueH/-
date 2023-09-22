package changep.t3;
public class RGBLight implements Runnable{
    Signal signal;
    Thread thread =new Thread(this);
    //
    public void startRGB(Signal signal){
        this.signal=signal;
        thread.start();
    }
    @Override
    public void run(){
        int x=0;
        while (true){
            if(x<12000)x=x+1;
            else x=0;
            int n=x%4;
            switch (n){
                    case 1:signal.setName("红灯：禁止通行");
                    System.out.println(signal.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) { }
                    break;
                    case 2:signal.setName("黄灯：预备等待");
                    System.out.println(signal.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) { }
                    break;
                    case 3:signal.setName("绿灯：请通行");
                    System.out.println(signal.getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) { }
                    break;
            }
        }
    }
}