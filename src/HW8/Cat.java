package HW8;

public class Cat implements Competitor {
    private static int count;
    private int id;
    private final int maxRun;
    private final int maxJump;

    public Cat(int maxRun, int maxJump) {
        count++;
        this.id = count;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Кошка №" + getId();
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public void run() {
        System.out.println("Кошка бежит...");
    }

    @Override
    public void jump() {
        System.out.println("Кошка прыгает...");
    }

    /*public void run1(int distance) {
        if (distance <= maxRun) {
            System.out.printf("Дистанция %d метров успешно преодолена.%n", distance);
        } else {
            System.out.printf("Дистанция %d метров не преодолена! Игрок выбывает.%n", distance);
        }
    }
    public void jump1(int height) {
        if (height <= maxJump) {
            System.out.printf("Высота %d метров успешно преодолена.%n", height);
        } else {
            System.out.printf("Высота %d метров не преодолена! Игрок выбывает.", height);
        }
    }*/

}
