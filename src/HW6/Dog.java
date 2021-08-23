package HW6;

public class Dog extends Pet{

    int maxRun = 500;
    int maxSwim = 10;

    public Dog() {
        this("Безымянная собака");
    }
    public Dog(String id) {
        super(id);
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRun) System.out.printf("%s (собака) пробежала %s метров %n", this.getId(), distance);
        else System.out.printf("%s (собака) пробежала %s метров %n", this.getId(), maxRun) ;

    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwim) System.out.printf("%s (собака) проплыла %s метров %n", this.getId(), distance);
            else System.out.printf("%s (собака) проплыла %s метров %n", this.getId(), maxSwim) ;

    }
}
