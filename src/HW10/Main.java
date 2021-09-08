package HW10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
   из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
TODO Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер
 телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
  тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные
   поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
   результатов проверки телефонного справочника.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("=HW10=");
        doTask1();
        doTask2();
    }

    public static int countEntries(ArrayList arrayList, String entry) {
        int count = 0;
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            if ((iterator.next()).equals(entry)) {
                count++;
            }
        }
        return count;
    }

    public static String[] createSomeStringArray() {
        return new String[]{"Спартак", "Динамо", "Локомотив", "ЦСКА", "Динамо", "Факел", "Ротор", "Торпедо", "Зенит", "Спартак", "Динамо"};
    }

    public static void doTask1() {
        System.out.println("* TASK 1 *");
        String[] array = createSomeStringArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String word : array) {
            arrayList.add(word);
        }
        System.out.println("Исходный массив: " + arrayList);

        HashSet<String> set = new HashSet<>(arrayList);
        System.out.println("Уникальные элементы массива: " + set);

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String currentWord = arrayList.get(i);
            hashMap.put(currentWord, countEntries(arrayList, currentWord));
        }
        System.out.println("Считаем количество вхождений: " + hashMap);
        System.out.println();
    }

    public static void doTask2() {
        System.out.println("* TASK 2 *");

    }
}
