package HW11;

public abstract class Fruit {
    private final float weight; // обязательно ли в этом случае делать геттер или допускается через public final ?

    public float getWeight() {
        return weight;
    }

    protected Fruit(float weight) {
        this.weight = weight;
    }

}
