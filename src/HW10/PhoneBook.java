package HW10;

import java.util.*;

public class PhoneBook{

    private final Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String number) {
        Set<String> numbers = new HashSet<>();
        if (phoneBook.containsKey(name)) numbers = phoneBook.get(name);
        numbers.add(number);
        phoneBook.put(name, numbers);
    }

    public Set<String> get(String name) {
        return phoneBook.get(name);
    }

    @Override
    public String toString() {
        return this.phoneBook.toString();
    }
}
