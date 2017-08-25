package test;

public class KuihuaTest {

	static int x = 10;
	static {
		x += 5;
	}

	public static void main(String[] args) {
		System.out.println("x=" + x);
	}

	static {
		x /= 3;
	}
}
class HasStatic{
	private static int x = 100;
	public static void main(String[] args) {
		HasStatic hs1=new HasStatic();
		hs1.x++;
		HasStatic hs2=new HasStatic();
		hs2.x++;
		hs1=new HasStatic();
		hs1.x++;
		HasStatic.x--;

		System.out.println("x=" + x);
		System.out.println(getValue(2));
		Child c=new Child("mike");
	}
	public static int getValue(int i){
		int result=0;
		switch(i){
		case 1:
			result = result + i;
		case 2:
			result = result + i*2;
		case 3:
			result = result + i*3;
		}
		return result;
	}
}
class People{
	String name;
	public People(){
		System.out.println(1);
	}
	public People(String name){
		System.out.println(2);
		this.name=name;
	}
}
class Child extends People{
	People father;
	public Child(String name){
		System.out.println(3);
		this.name=name;
		father = new People(name+":F");
	}
	public Child(){System.out.println(4);}
}
class Example{
	String str = new String("good");
	char[] ch = {'a','b','c'};
	public static void main(String[] args){
		Example ex=new Example();
//		String str = new String("good");
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str+" and ");
		System.out.println(ex.ch);

	}
	public void change(String str,char[] ch){
//		Example ex=new Example();
		str="test ok";
		ch[0]='g';
	}
}
//单例模式
class SingletonTest {

    // 定义一个私有的构造方法
    private SingletonTest() {
    }

    // 将自身的实例对象设置为一个属性,并加上Static和final修饰符
    private static final SingletonTest instance = new SingletonTest();

    // 静态方法返回该类的实例
    public static SingletonTest getInstancei() {
        return instance;
    }
}

class Singleton {
	private Singleton(){};

	private static final Singleton instance = new Singleton();

	public static Singleton getInstance() {
		return instance;
	}
}

