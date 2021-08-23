package Homework06;

public class Soldier extends Unit{

    @Override
    public void move() {
        System.out.println("soldier moving!");
    }

    @Override
    public void stop() {
        System.out.println("soldier stopping");
    }
}
