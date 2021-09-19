package Homework06;
//

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");
        moveUnitsForward(createUnits());
    }
    static void moveUnitsForward (Unit[] units){
        for (int i = 0; i < units.length; i++) {
            units[i].move();
        }
    }
    static Unit[] createUnits() {
        return new Unit[]{
                new Probe(), new Soldier()
        };
    }
}
