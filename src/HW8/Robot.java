package HW8;

public class Robot implements Competitor {
    private static int count;
    private int id;
    private final int maxRun;
    private final int maxJump;

    public Robot(int maxRun, int maxJump) {
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
        return "Робот №00" + getId();
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
        System.out.println("Робот бежит");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает");
    }
}
