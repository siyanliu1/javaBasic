import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    
    // This method is not synchronized, which allows race conditions
    public void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

class SynchronizedCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();
    
    // Thread-safe method using ReentrantLock
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    
    public int getCount() {
        return count;
    }
}

class Singleton {
    private static volatile Singleton instance;
    private static final ReentrantLock lock = new ReentrantLock();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new Singleton();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }
}

public class MainProgram {
    public static void main(String[] args) throws InterruptedException {
        runCounterTest();
        runSynchronizedCounterTest();
        runSingletonTest();
        runDeadlockTest();
    }
    
    // Test case for counter thread interference issue (without synchronization)
    private static void runCounterTest() throws InterruptedException {
        Counter counter = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        // Expected output should be 2000, but due to thread interference,
        // the result will often be lower than 20000.
        System.out.println("Final count (without synchronization): " + counter.getCount());
    }
    
    // Test case for counter with synchronization
    private static void runSynchronizedCounterTest() throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        // Expected output should always be 20000 due to synchronization.
        System.out.println("Final count (with synchronization): " + counter.getCount());
    }
    
    // Test case for verifying singleton instance in a multi-threaded environment
    private static void runSingletonTest() {
        Thread t3 = new Thread(() -> {
            Singleton singleton1 = Singleton.getInstance();
            System.out.println("Singleton Instance 1: " + singleton1.hashCode());
        });
        
        Thread t4 = new Thread(() -> {
            Singleton singleton2 = Singleton.getInstance();
            System.out.println("Singleton Instance 2: " + singleton2.hashCode());
        });
        
        t3.start();
        t4.start();
        
        // Both threads should print the same hashCode, proving that only one instance is created
    }
    
    // Test case demonstrating a potential deadlock situation and solution
    private static void runDeadlockTest() {
        Object key1 = new Object();
        Object key2 = new Object();
        
        Thread t8 = new Thread(() -> {
            synchronized (key1) {
                System.out.println("t8 has key 1.");
                synchronized (key2) {
                    System.out.println("t8 has key 2");
                }
            }
        });
        
        Thread t9 = new Thread(() -> {
            synchronized (key1) { // Changed order to avoid deadlock
                System.out.println("t9 has key 1.");
                synchronized (key2) {
                    System.out.println("t9 has key 2");
                }
            }
        });
        
        t8.start();
        t9.start();
        
        // Expected output: Both threads should acquire locks in a consistent order to avoid deadlock
    }
}
