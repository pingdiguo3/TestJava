package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class MsgDemo {
    String mes;

    public synchronized void setMes(String str) {
        this.mes = str;
    }

    public synchronized String getMes() {
        return this.mes;
    }

    static class MegIn extends Thread {
        String workerName;
        CountDownLatch latch;
        MsgDemo demo;

        public MegIn(String workerName, MsgDemo demo, CountDownLatch latch) {
            this.workerName = workerName;
            this.latch = latch;
            this.demo = demo;
        }

        public void run() {
            demo.setMes(workerName);
            System.out.println(demo.getMes());
            latch.countDown();

        }
    }

    static class MegOut extends Thread {
        MsgDemo demo;
        CountDownLatch latch;

        public MegOut(MsgDemo demo, CountDownLatch latch) {
            this.demo = demo;
            this.latch = latch;
        }

        public void run() {
            System.out.println("翻译后的信息:" + demo.getMes());
            latch.countDown();

        }

    }

    public static void main(String[] args) throws InterruptedException {
        MsgDemo demo = new MsgDemo();
        for (int i = 0; i < 50; i++) {
            CountDownLatch latch = new CountDownLatch(1);
            MegIn worker1 = new MegIn("a" + i, demo, latch);
            worker1.start();
            latch.await();
            CountDownLatch latch2 = new CountDownLatch(1);
            MegOut out = new MegOut(demo, latch2);
            out.start();
            latch2.await();
        }

    }
}
