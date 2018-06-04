package thread.lock;

public class MainClass {
    public static void main(String[] args) {
        for(int index = 0 ; index < 10;index++){
            MyThread03 thread = new MyThread03();
            thread.start();
        }
    }
}
class MyThread03 extends Thread{
    public void run(){
        //每个线程均创建一个TestForSynchronized实例
        TestForSynchronized temp=new TestForSynchronized();
        System.out.println(Thread.currentThread().getName()+"--"+temp.setId02());
    }
}
