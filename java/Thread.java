import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class HelloWorld {
    public static void main(String[] args) {
        Object spoon = new Object();
        Object bowl = new Object();

        ReentrantLock spoonLock = new ReentrantLock(true);  // fair
        ReentrantLock bowlLock = new ReentrantLock();       // not fair

        Thread t1 = new Thread(() -> {
            try {
                bowlLock.lock();
                System.out.println("Im t1 holding bowl waiting for spoon");
                spoonLock.lock();
                System.out.println("Im t1 holding spoon");
            } finally {
                spoonLock.unlock();
                bowlLock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                boolean isSpoonFree = spoonLock.tryLock(10, TimeUnit.SECONDS); // not fair

                if (isSpoonFree) {
                    try {
                        System.out.println("Im t2 holding spoon waiting for bowl");
                        try {
                            boolean isBowlFree = bowlLock.tryLock(1, TimeUnit.SECONDS);
                            if (isBowlFree) {
                                System.out.println("Im t2 holding bowl");
                            }
                        } catch (InterruptedException e) {
                            System.out.println("t2 stops waiting for bowl");
                        } finally {
                            bowlLock.unlock();
                        }
                    } finally {
                        spoonLock.unlock();
                    }
                }
            } catch (Exception e) {
                System.out.println("t2 stops waiting for spoon");
            }
        });

        t1.start();
        t2.start();
    }
}
