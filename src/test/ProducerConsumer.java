package test;

public class ProducerConsumer {

    public static void main(String[] args) {

        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();
        new Thread(c).start();
    }

}

class WoTou {
    int id;

    WoTou(int id) {
        this.id = id;
    }

    public String toString() {
        return "WoTou:" + id;
    }
}

class SyncStack {
    int index = 0;
    WoTou[] wotou = new WoTou[6];

    public synchronized void push(WoTou wt) throws InterruptedException {
        if (index == wotou.length) {
            this.wait();
        }
        this.notify();
        wotou[index] = wt;
        index++;
    }

    public synchronized WoTou pop(WoTou wt) throws InterruptedException {
        // if(index <=wotou.length){
        if (index == 0) {
            this.wait();
        }
        this.notify();
        index--;
        return wotou[index];

        // }
    }
}

class Producer implements Runnable {

    SyncStack ss = null;

    Producer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 20; i++) {
            WoTou wt = new WoTou(i);
            try {
                ss.push(wt);
                System.out.println("生产了:" + wt);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable {

    SyncStack ss = null;

    Consumer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 20; i++) {
            WoTou wt = new WoTou(i);
            try {
                ss.pop(wt);
                System.out.println("消费了:" + wt);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
