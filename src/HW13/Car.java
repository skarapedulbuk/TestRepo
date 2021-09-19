package HW13;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier prepare;
    private CountDownLatch finishCountDown;
    private Lock lock;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Lock finishLock, CountDownLatch finishCountDown, CyclicBarrier cb, Race race, int speed) {
        this.lock = finishLock;
        this.finishCountDown = finishCountDown;
        this.prepare = cb;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        //  new Thread(this).start();
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            handleAwait(prepare);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (finishCountDown.getCount() == 4) {
            try {
                lock.lock();
                System.out.println("Победа игрока: " + this.name);
            } finally {
                lock.unlock();
            }
        }
        finishCountDown.countDown();
    }

    static void handleAwait(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
