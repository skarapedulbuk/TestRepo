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
    private Lock finishLock;
    private Object lock1 = new Object();


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Lock finishLock, CountDownLatch finishCountDown, CyclicBarrier prepare, Race race, int speed) {
        this.finishLock = finishLock;
        this.finishCountDown = finishCountDown;
        this.prepare = prepare;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            handleAwait(prepare);
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            handleLock(finishLock, this.name);
            finishCountDown.countDown();
            //finishLock.lock();

        } catch (Exception e) {
            e.printStackTrace();
       }
    }

    static void handleAwait(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    static void handleLock(Lock finishLock, String name) {
        if (finishLock.tryLock()) {
            System.out.println("Победа игрока: " + name);
        }
    }
}
