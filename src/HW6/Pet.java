package HW6;

public abstract class Pet {

    private final String id;

    public String getId() {
        return id;
    }

    public boolean isPet() {
        return true;
    }

    public Pet(String id) {
        this.id = id;
    }

    public abstract void run(int distance);
    public abstract void swim (int distance);
}
