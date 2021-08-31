package HW8;

public class Cat implements Competitor{
    private int id;
    private final int maxRun;
    private final int maxJump;

    public Cat(int maxRun, int maxJump) {
        id++;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    public String toString() {
        return "Кошка №" + getId();
    }
    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.printf("Дистанция %d метров успешно преодолена.%n", distance);
        } else {
            System.out.printf("Дистанция %d метров не преодолена! Игрок выбывает.%n", distance);
        }
    }
    public void jump(int height) {
        if (height <= maxJump) {
            System.out.printf("Высота %d метров успешно преодолена.%n", height);
        } else {
            System.out.printf("Высота %d метров не преодолена! Игрок выбывает.", height);
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }
}
