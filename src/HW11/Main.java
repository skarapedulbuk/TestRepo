package HW11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 2. Написать метод, который преобразует массив в ArrayList;
TODO 3. Задача:
TODO a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
TODO b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
TODO c. Для хранения фруктов внутри коробки можно использовать ArrayList;
TODO d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
TODO e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
TODO f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
TODO g. Не забываем про метод добавления фрукта в коробку.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("=HW11=");
        String[] array = createSomeStringArray();
        replaceArrayEntries(array, 0, 5); // задача 1
        List<String> arrayList = convertArrayToArrayList(array); // задача 2 (м.б. я неправильно понял суть задачи?)
        System.out.println(arrayList);
    }

    public static <T> void replaceArrayEntries(T[] array, int i, int j) {
        System.out.printf("Меняю местами элементы %d и %d...%n", i + 1, j + 1);
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static String[] createSomeStringArray() {
        return new String[]{"Спартак", "Динамо", "Локомотив", "ЦСКА", "Динамо", "Факел", "Ротор", "Торпедо", "Зенит", "Спартак", "Динамо"};
    }

    public static <T> void printArray(T[] array) {
        System.out.printf("Массив %s: ", array.getClass().getCanonicalName());

        for (T entry : array
        ) {
            System.out.printf("%s, ", entry);
        }
        System.out.println();
    }

    public static <T> List<T> convertArrayToArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }
}
