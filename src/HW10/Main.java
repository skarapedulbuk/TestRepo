package HW10;

import java.util.*;

/* Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
   из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
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

    public static int countEntries(List<String> arrayList, String entry) {
        int count = 0;
        for (String currentWord : arrayList) {
            if (currentWord.equals(entry)) {
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
        List<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        System.out.println("Исходный массив: " + arrayList);

        HashSet<String> set = new HashSet<>(arrayList);
        System.out.println("Уникальные элементы массива: " + set);

        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String currentWord = arrayList.get(i);
            hashMap.put(currentWord, countEntries(arrayList, currentWord));
        }
        System.out.println("Считаем количество вхождений: " + hashMap);
        System.out.println();
    }

    public static void doTask2() {
        System.out.println("* TASK 2 *");

        PhoneBook phoneBook1 = new PhoneBook();
        String target = "Бен Ладен";

        phoneBook1.add("Путин", "+7495001");
        phoneBook1.add("Лукашенко", "+375175");
        phoneBook1.add("Зеленский", "+380504");
        phoneBook1.add("Бен Ладен", "+9320");
        phoneBook1.add("Бен Ладен", "+1212");
        phoneBook1.add("Бен Ладен", "+966");
        phoneBook1.add("Елизавета 2", "+445045");

        System.out.println(phoneBook1);
        System.out.printf("По запросу '%s' найдены следующие телефоны: ", target);
        System.out.println(phoneBook1.get(target));
    }
}
