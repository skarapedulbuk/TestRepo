package HW8;

public class Human implements Competitor {
    private static int count;
    private int id;
    private final int maxRun;
    private final int maxJump;

    public Human(int maxRun, int maxJump) {
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
        return "Человек №0" + getId();
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
        System.out.println("Чел бежит");
    }

    @Override
    public void jump() {
        System.out.println("Чел прыгает");
    }
}
