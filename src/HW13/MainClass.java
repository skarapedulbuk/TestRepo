package HW13;
/*
Перенести приведенный ниже код в новый проект, где мы организуем гонки.
+ Все участники должны стартовать одновременно, несмотря на разное время подготовки.
+ В тоннель не может одновременно заехать больше половины участников (условность).
+ Попробуйте все это синхронизировать.
+ Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты).
+ Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).
+ Когда все завершат гонку, нужно выдать объявление об окончании.
+ Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из пакета java.util.concurrent.
*/

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch finishCountDown = new CountDownLatch(CARS_COUNT);
    public static final Lock finishLock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {
        Car[] cars = new Car[CARS_COUNT];
        createRandomCompetition(cars);
        startTheCompetition(cars);
    }

    public static void createRandomCompetition(Car[] cars) {
        final CyclicBarrier prepare = new CyclicBarrier(CARS_COUNT,
                () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        final Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Arrays.setAll(cars, i -> new Car(finishLock, finishCountDown, prepare, race, 20 + (int) (Math.random() * 10)));
    }

    public static void startTheCompetition(Car[] cars) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Arrays.stream(cars).forEach(car -> new Thread(car).start());
        finishCountDown.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}