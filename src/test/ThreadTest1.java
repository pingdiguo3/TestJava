package test;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadTest1 {

    public static void main(String[] args) {

        Print p = new Print();
        new A(p).start();

        new B(p).start();
        /*Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.print(0);
			}
		}, 3000, 1000);

		Timer timer1 = new Timer();
		timer1.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.print(1);
			}
		}, 3000, 1000);*/
    }
}

class Print {
    int a, b = 0;
    boolean flag = true;

    public void A() {
        while (a <= 100) {
            if (flag) {
                System.out.print(0);
                a++;
                this.flag = false;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void B() {
        while (b <= 100) {
            if (!flag) {
                System.out.print(1);
                b++;
                this.flag = true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

class A extends Thread {

    Print p = null;

    public A(Print p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.A();// 打印小写
        // p.B();

    }

}

class B extends Thread {

    Print p = null;

    public B(Print p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.B();// 打印小写
        // p.B();
    }
}
