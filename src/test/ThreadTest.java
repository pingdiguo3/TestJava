package test;

public class ThreadTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Myprint m = new Myprint();
        new Capital(m).start();
        new Lowercase(m).start();
    }
}

/*update test set name=(select name from test1 where test.id=test1.id)
where exists (select name from test1 where test.id=test1.id);
and test.name<>test1.name);*/
class Myprint {
    boolean flag = true;
    int i = 0;
    int j = 0;

    public void Da() {
        while (i < 26) {
            if (flag) {
                System.out.print((char) ('A' + i));
                i++;
                this.flag = false;
            }
        }
    }

    public void Xiao() {
        while (j < 26) {
            if (!flag) {
                System.out.print((char) ('a' + j));
                j++;
                this.flag = true;
            }
        }
    }
}

class Capital extends Thread {
    Myprint my = null;

    public Capital(Myprint my) {
        this.my = my;
    }

    @Override
    public void run() {
        my.Da();// 打印大写
    }
}

class Lowercase extends Thread {
    Myprint my = null;

    public Lowercase(Myprint my) {
        this.my = my;
    }

    @Override
    public void run() {
        my.Xiao();// 打印小写
    }
}
