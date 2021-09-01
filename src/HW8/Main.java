package HW8;

/* Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать
    и прыгать (методы просто выводят информацию о действии в консоль).

TODO Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
 соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог
 пробежать и т.д.).

TODO Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

TODO * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если
 участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("=HW8=");
        System.out.println("***************************************************************");
        System.out.println("Соревнования по двоеборью среди кошек, людей и роботов - 2021.");
        System.out.println("***************************************************************");

        Competitor[] units = generateSomeUnits();
        printList(units);
        Barrier[] barriers = generateSomeBarriers();
        for (Competitor unit : units
        ) {
            tryToPass(unit, barriers);
        }

    }

    public static Barrier[] generateSomeBarriers() {
        return new Barrier[]{
                new Route(2),
                new Wall(1),
                new Route(5),
                new Wall(3),
                new Route(25)
        };
    }

    public static Competitor[] generateSomeUnits() {
        return new Competitor[]{
                new Cat(5, 2),
                new Cat(4, 1),
                new Cat(3, 0),
                new Human(10, 1),
                new Human(15, 0),
                new Human(20, 1),
                new Robot(130, 10)
        };
    }

    public static void printList(Competitor[] units) {
        System.out.println("Список участников:");
        System.out.println("------------------");
        for (Competitor unit : units
        ) {
            System.out.printf("%s       %d      %d%n", unit.toString(), unit.getMaxRun(), unit.getMaxJump());
        }
        System.out.println("------------------");
    }

    public static boolean tryToPass(Competitor unit, Barrier[] barriers) {
        boolean isPassed = false;
        System.out.println("__________________________________________________");
        System.out.printf("%s пробует пройти полосу препятствий...%n", unit.toString());
        for (Barrier barrier : barriers
        ) {
            if (barrier.isJumpable(unit.getMaxJump()) || barrier.isRunnable(unit.getMaxRun())) {
                System.out.printf("+ Препятствие преодолено (%s)%n", barrier);
            } else {
                System.out.printf("- Препятствие не преодолено (%s) %n%s выбывает из соревнований :(%n", barrier, unit);
                return false;
            }
        }
        System.out.printf("!!! %s успешно завершил полосу препятствий !!!%n", unit);
        return true;
    }

}
