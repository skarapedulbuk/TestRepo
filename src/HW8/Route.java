package HW8;

public class Route implements Barrier {
    private final int distance;

    public Route(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean isRunnable(int maxRun) {
        return maxRun >= distance;
    }

    @Override
    public boolean isJumpable(int maxJump) {
        return false;
    }

    @Override
    public String toString() {
        return "Бег на дистанцию " + getDistance() + " м";
    }
}
