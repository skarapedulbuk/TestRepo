package HW7;
/*  Расширить задачу про котов и тарелки с едой.

 Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
 (например, в миске 10 еды, а кот пытается покушать 15-20).

 Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
 удалось покушать (хватило еды), сытость = true.

 Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может
 быть наполовину сыт (это сделано для упрощения логики программы).

 Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
 потом вывести информацию о сытости котов в консоль.

 Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("=HW7=");
        doTask5();
    }

    static void doTask5() {
        Plate plate = new Plate(0);
        plate.increaseFood(100); // метод, с помощью которого можно было бы добавлять еду в тарелку (задание 6)
        plate.info();
        Cat[] cats = new Cat[]{new Cat("Barsik", 5), new Cat("Murzik", 100), new Cat("Pushok", 13)};
        for (Cat cat : cats) {
            System.out.printf("Просим %s поесть из миски... ", cat.getName());
            cat.eat(plate);
            plate.info();
        }
        countPets(cats);
        plate.info();

    }
    static void countPets (Cat[] pets) {
        System.out.println("Инвентаризация котов:");
        int catCounter = 0;
        for (int i = 0; i < pets.length; i++) {
            System.out.printf("№%d. Кличка: %s, аппетит: %d, сытость: %s%n",
                    i+1,
                    pets[i].getName(),
                    pets[i].getAppetite(),
                    pets[i].isNotHungry()
            );
            catCounter++;
        }
        System.out.printf(" Итого котов: %d%n ", catCounter);
    }
}
