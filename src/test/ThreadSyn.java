package test;

public class ThreadSyn implements Runnable {

    Timer tim = new Timer();

    public static void main(String[] args) {
        ThreadSyn test = new ThreadSyn();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        tim.add(Thread.currentThread().getName());
    }

}

class Timer {
    private static int num = 0;

    public synchronized void add(String name) {
        try {
            num++;
            Thread.sleep(1);
        } catch (InterruptedException e) {

        }
        System.out.println(name + ",你是第" + num + "个timer线程。");
    }
}