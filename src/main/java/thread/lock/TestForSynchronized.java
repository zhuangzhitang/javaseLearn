package thread.lock;

/**
 * 1.在多线程场景下，对于某一个类实例(对象)tempObject,如果多个线程并发通过tempObject访问其synchronized方法或者synchronized块时，
 * 任何一个时刻只有一个线程处于可执行状态，因为同一时刻只有一个线程能够获取该实例的唯一的锁，
 * 其它线程都会被阻塞，直到synchronized方法返回或者synchronized块执行完毕，锁才会被占用的线程释放，
 * 此前被阻塞的线程才有机会获得该对象的锁；
 * 2.在多线程场景下，对于某一个类实例(对象)tempObject，如果一个线程获得tempObject的锁，
 * 在一个synchronized方法返回或者一个synchronized块执行完毕后，便会将锁释放，而不会继续持有锁，
 * 即使该线程接下来仍需执行该实例tempObject的其它synchronized方法或者synchronized块
 * 3.前已述及，采用了synchronized机制的类，其每一个实例都有一个锁(对象级别的锁)，事实上，类也有唯一的锁，换言之，采用了synchronized机制的类有一个类锁；
 * 多线程场景下，当某一线程获得类锁(注意：不再是对象锁)，其它线程将被阻塞，将无法调用或访问该类的所有方法和域，包括静态方法和静态变量；
 * 对于含有静态方法和静态变量的代码块的同步，类锁的严格约束在多线程场景下非常实用，应用也较多。
 */
public class TestForSynchronized {
    static int ID = 0;
    private static Object mutex = new Object();
    //测试synchronized(对象级)
    public String setId01(){
        synchronized (this){
            ID++;
            return "setID_01() ID No.:"+ID;
        }
    }
    //测试(类级别)
    public String setId02(){
        synchronized (TestForSynchronized.class){
            ID++;
            return "setID_02() ID No.:"+ID;
        }
    }

    //测试 synchronized 方法
    public synchronized  String setId03(){
        ID++;
        return "setID_03() ID No.:"+ID;
    }
    //普通方法
    public  String commonMethod()
    {
        return "commonMethod ID No."+ID;
    }

    public String setId04(){
        synchronized (mutex){
            ID++;
            return "setID_02() ID No.:"+ID;
        }
    }
}
