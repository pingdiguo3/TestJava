package test;

public class ThreadR {

    public static void main(String[] args) throws InterruptedException {
        /*
		 * Runner1 A = new Runner1("A"); Runner1 B = new Runner1("B"); A.run();
		 * 
		 * B.run();
		 */

        Thread1 A1 = new Thread1("A");
//		Thread1 B1 = new Thread1("B");
        A1.start();
        // A1.sleep(100);
//		B1.start();
        // B1.sleep(100);
        try {
            Thread.sleep(10000);
//			A1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A1.interrupt();
		/*for (int i = 0; i < 100; i++) {
			
			 * try { Thread.sleep(100); } catch (InterruptedException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 
			System.out.println("Main Thread:" + i);
		}*/
    }

}

class Runner1 implements Runnable {
    private String a;

    Runner1(String a) {
        this.a = a;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(a + i);
			/*try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        }
    }
}

class Thread1 extends Thread {
//	private String a;

    Thread1(String a) {
//		this.a = a;
        super(a);
    }

    int i = 0;

    public void run() {
        boolean flag = true;
//		for (int i = 0; i < 100; i++) {
        while (true) {
            System.out.println(i);
            i++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
//				e.printStackTrace();
                return;
//				Thread.interrupted();
            }
        }
    }
}
