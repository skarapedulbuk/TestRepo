package HW6;

public class Cat extends Pet{

    int maxRun = 200;
    int maxSwim = 0;

    public Cat() {
        this("Безымянная кошка");
    }

    public Cat(String id) {
        super(id);
    }

    @Override
    public void run(int distance) {
        while (Math.abs(distance) < maxRun) {
            System.out.printf("%s пробежала %d метров %n", this.getId(), distance);
            break;
        }
        System.out.printf("%s пробежала %d метров %n",this.getId(), maxRun);
    }

    @Override
    public void swim(int distance) {
        while (Math.abs(distance) < maxSwim) {
            System.out.printf("%s проплыла %d метров %n",this.getId(), distance);
            break;
        }
        System.out.printf("%s проплыла %s метров %n",this.getId(), maxSwim);
        //   System.out.printf("%s не умеет плавать %n", this.getId());


    }
}
