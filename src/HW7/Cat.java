package HW7;

public class Cat {

    private String name;
    private int appetite;
    private boolean notHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.notHungry = false;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            setNotHungry(true);
            System.out.printf("%s съел %d еды... ", name, appetite);
        } else {
            System.out.printf("У кота %s аппетит больше, чем еды в миске, он не будет есть... ", name);
        }
    }

    public String getName () {
        return name;
    }
    public Integer getAppetite() {
        return appetite;
    }
    public boolean isNotHungry() {
        return notHungry;
    }
    public void setNotHungry(boolean notHungry) {
        this.notHungry = notHungry;
    }
}


