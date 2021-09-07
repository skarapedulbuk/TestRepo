package HW7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood(){
        return food;
    }
    public void info() {
        System.out.println("Остаток корма в миске: " + food);
    }

    public void decreaseFood(int n) {
        food -= n;
    }
    public void increaseFood(int n) {
        food += n;
    }
}


