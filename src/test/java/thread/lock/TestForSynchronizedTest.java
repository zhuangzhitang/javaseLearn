package thread.lock;


public class TestForSynchronizedTest {

    public static void main(String[] args) {
        TestForSynchronized temp = new TestForSynchronized();
        for(int index = 0 ; index < 10 ;index ++){
            MyThread01 thread01 = new MyThread01(temp);
            thread01.start();
        }
    }
}

class  MyThread01 extends  Thread{
    TestForSynchronized testObject;

    public MyThread01(TestForSynchronized testObject) {
        this.testObject = testObject;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--"+testObject.setId03());
        System.out.println(Thread.currentThread().getName()+"--"+testObject.setId01());
    }
}
