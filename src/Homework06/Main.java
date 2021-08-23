package Homework06;
// TODO: 23.08.2021       Создать классы Собака и Кот с наследованием от класса Животное.
// TODO: 23.08.2021       Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина
//  препятствия. Результатом выполнения действия будет печать в консоль.
//  (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
// TODO: 23.08.2021       У каждого животного есть ограничения на действия
//  (бег: кот 200 м., собака 500 м.;
//  плавание: кот не умеет плавать, собака 10 м.).
// TODO: 23.08.2021       * Добавить подсчет созданных котов, собак и животных.

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
