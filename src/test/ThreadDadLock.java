package test;

public class ThreadDadLock implements Runnable {

    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();

    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {

                }
            }
            synchronized (o2) {
                System.out.println("1");
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {

                }
            }
            synchronized (o2) {
                System.out.println("0");
            }
        }
    }

    public static void main(String[] args) {
        ThreadDadLock t1 = new ThreadDadLock();
        ThreadDadLock t2 = new ThreadDadLock();
        t1.flag = 1;
        t2.flag = 0;
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        tt1.start();
        tt2.start();
    }
}
