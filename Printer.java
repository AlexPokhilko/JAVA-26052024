
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

// import java.util.Arrays;
// import java.util.Collection;
// import java.util.*;
// import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

class CreatePhoneBook {

  private static HashMap<String, ArrayList<Long>> phoneBook = new HashMap<>();
  private HashMap<String, Integer> tempHashMap = new HashMap<>();

  public void add(String name, Long phoneNum) {

    boolean check = phoneBook.containsKey(name);

    ArrayList<Long> entry = new ArrayList<Long>();

    if (!check) {
      entry.add(phoneNum);
      phoneBook.put(name, entry);
    } else {
      entry = phoneBook.get(name);
      entry.add(phoneNum);
      phoneBook.put(name, entry);
    }
  }

  public void CreateNumbers() {

    String nameSource[] = { "Маша", "Катя", "Света", "Вова", "Петя", "Гриша", "Аня", "Дима", "Толя", "Костя", "Саша" };
    String phoneNumber = "";
    int n = 10;
    int l = nameSource.length;
    String name = "";

    for (int j = 0; j < nameSource.length; j++) {
      name = "";
      phoneNumber = "";
      for (int k = 0; k < nameSource.length; k++) {
        int b = (int) (Math.random() * l);
        name = nameSource[b];
      }      
      for (int k = 0; k < n; k++) {
        long i = (long) (Math.random() * 10);
        phoneNumber = phoneNumber + String.valueOf(i);
      }      
      add(name, Long.parseLong(phoneNumber));
    }

    System.out.println();
    System.out.println(phoneBook);
  }

  public int sortNumbers() {

    int max = 0;
    // System.out.println(phoneBook);
    ArrayList<Long> al = new ArrayList<>();

    for (String name : phoneBook.keySet()) {

      al = phoneBook.get(name);
      tempHashMap.put(name, al.size());
      if (max < al.size())
        max = al.size();
    }

    // System.out.println(max);
    // System.out.println(tempHashMap);

    return max;
  }

  public void sortForPrint(int max) {

    ArrayList<Long> al = new ArrayList<>();

    System.out.println();
    System.out.println("Вариант 1:");

    for (int i = max; i > 0; i--) {
      for (String key : tempHashMap.keySet()) {
        if (i == tempHashMap.get(key)) {
          al = phoneBook.get(key);
          String phones = "";
          for (int j = 0; j < al.size(); j++) {
            phones = phones + String.valueOf(al.get(j)) + " ";
          }
          phones.trim();
          System.out.println(key + " " + phones);
        }
      }
    }
    
    System.out.println();
    System.out.println("Вариант 2:");

    for (int i = max; i > 0; i--) {
      for (String key : tempHashMap.keySet()) {
        if (i == tempHashMap.get(key)) {
          al = phoneBook.get(key);
          for (int j = 0; j < al.size(); j++) {
            System.out.println(key + " " + String.valueOf(al.get(j)));
          }
        }
      }
    }
  }
}

public class Printer {
  public static void main(String[] args) {

    int max = 0;

    CreatePhoneBook cpb = new CreatePhoneBook();
    cpb.CreateNumbers();
    max = cpb.sortNumbers();
    cpb.sortForPrint(max);

  }
}

