package HW6;
// Создать классы Собака и Кот с наследованием от класса Животное.
// Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина
//  препятствия. Результатом выполнения действия будет печать в консоль.
//  (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
// У каждого животного есть ограничения на действия
//  (бег: кот 200 м., собака 500 м.;
//  плавание: кот не умеет плавать, собака 10 м.).
// * Добавить подсчет созданных котов, собак и животных.
public class Main {


    public static void main(String[] args) {
        Pet[] somePets = createSomePetsManually();

        somePets[3].swim(5);
        somePets[2].run(25);
        swimPetsForward(somePets, 7);
        runOnePetForward(somePets, "Муся", 220);

        countPets(somePets);
    }

    static void runOnePetForward (Pet[] pets, String name, int distance) {
        for (Pet pet : pets) {
            if (pet.getId().equals(name)) {
                System.out.printf("%s получает задание пробежать %d метров...%n", name, distance);
                pet.run(distance);
            }
        }
    }
    static void swimPetsForward (Pet[] pets, int distance){
        for (Pet pet : pets) {
            pet.swim(distance);
        }
    }
    static Pet[] createSomePetsManually() {
        System.out.println("Создаем произвольный массив домашних животных...");
        return new Pet[]{
                new Cat("Муся"), new Cat("Буся"), new Dog("Белка"), new Dog("Стрелка")
        };
    }

    static void countPets (Pet[] pets) {
        System.out.println("Инвентаризация животных:");
        int catCounter = 0, dogCounter = 0, petCounter = 0;
        for (Pet pet:pets
             ) {
            if (pet.getClass().equals(Cat.class)) catCounter++;
            if (pet.getClass().equals(Dog.class)) dogCounter++;
            if (pet.isPet()) petCounter++;
        }
        System.out.printf(" Кошек: %d%n Собак: %d%n Домашних животных: %d%n", catCounter, dogCounter, petCounter);
    }
}
