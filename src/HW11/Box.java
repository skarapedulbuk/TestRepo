package HW11;


public class Box<T extends Fruit> {

    private final T fruit;
    protected int count;

    public Box(T fruit, int count) {
        this.fruit = fruit;
        this.count = count;
    }

    public float getWeight() {
            return count * fruit.getWeight();
    }

    public void addFruit(int quantity) {
        count += quantity;
    }

    public boolean compare(Box<? extends Fruit> other) { // при попытке
        return this.getWeight() == other.getWeight();
    }

    public void merge(Box<T> other) {
       count += other.count;
       other.count = 0;
    }
}
