package HW8;

public class Wall implements Barrier {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Прыжок на высоту " + getHeight() + " м";
    }

    @Override
    public boolean isRunnable(int maxRun) {
        return false;
    }

    @Override
    public boolean isJumpable(int maxJump) {
        return maxJump >= height;
    }
}
