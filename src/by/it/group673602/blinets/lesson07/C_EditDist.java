package by.it.group673602.blinets.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить алгоритм преобразования двух данных непустых строк
    Вывести через запятую редакционное предписание в формате:
     операция("+" вставка, "-" удаление, "~" замена, "#" копирование)
     символ замены или вставки

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    #,#,

    Sample Input 2:
    short
    ports
    Sample Output 2:
    -s,~p,#,#,#,+s,

    Sample Input 3:
    distance
    editing
    Sample Output 2:
    +e,#,#,-s,#,~i,#,-c,~g,


    P.S. В литературе обычно действия редакционных предписаний обозначаются так:
    - D (англ. delete) — удалить,
    + I (англ. insert) — вставить,
    ~ R (replace) — заменить,
    # M (match) — совпадение.
*/


public class C_EditDist {

  public static void main(String[] args) throws FileNotFoundException {
    String root = System.getProperty("user.dir") + "/src/";
    InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
    C_EditDist instance = new C_EditDist();
    Scanner scanner = new Scanner(stream);
    System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
    System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
    System.out.println(instance.getDistanceEdinting(scanner.nextLine(), scanner.nextLine()));
  }

  public static Item levenstain(String str1, String str2) {
//    int[] Di_1 = new int[str2.length() + 1];
//    int[] Di = new int[str2.length() + 1];
    List<Item> Di_1 = new ArrayList<>();
    List<Item> Di = new ArrayList<>();

    for (int j = 0; j <= str2.length(); j++) {
      Di.add(j, new Item(j)); // (i == 0)
    }

    for (int j = 0; j <= str2.length(); j++) {
      Di_1.add(j, new Item(0)); // (i == 0)
    }

    for (int i = 1; i <= str1.length(); i++) {
      for (int j = 0; j < Di.size(); j++) {
        Di_1.set(j, new Item(Di.get(j)));
      }

      Di.get(0).length = i; // (j == 0)
      for (int j = 1; j <= str2.length(); j++) {
        int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
//        Di.get(j).length = Math.min(Math.min(Di_1.get(j).length + 1,Di.get(j-1).length + 1), Di_1.get(j-1).length + cost);

        Di.set(j, min(
            Di_1.get(j),
            Di.get(j - 1),
            Di_1.get(j - 1), cost));
      }
    }

    return Di.get(Di.size() - 1);
  }

  private static Item min(Item n1, Item n2, Item n3, int cost) {
    if (n1.length + 1 < n2.length + 1) {
      if (n1.length + 1 < n3.length + cost) {
        return new Item(n1.length + 1, n1.symbol + "+,");
      }
    } else {
      if (n2.length + 1 < n3.length + cost) {
        return new Item(n2.length + 1, n2.symbol + "-,");
      }
    }
    Item item;
    if (cost == 0) {
      item = new Item(n3.length + cost, n3.symbol + "#,");
    } else {
      item = new Item(n3.length + cost, n3.symbol + "~,");
    }
    return item;
  }

  String getDistanceEdinting(String one, String two) {
    //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

    Item levenstain = levenstain(one, two);
    System.out.println(levenstain.length);
    String result = levenstain.symbol;
    //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
    return result;
  }

  public static class Item {

    public int length;
    public String symbol;

    public Item(int length) {
      this.length = length;
      symbol = new String();
    }

    public Item(){
    symbol = new String();
    }

    public Item(Item item) {
      this.length = item.length;
      this.symbol = item.symbol;
    }

    public Item(int length, String symbol) {
      this.length = length;
      this.symbol = symbol;
    }

    public void merge(Item item) {
      this.length += item.length;
      this.symbol += item.symbol;
    }

    public int getLength() {
      return length;
    }

    public void setLength(int length) {
      this.length = length;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return "Item{" +
          "length=" + length +
          ", symbol='" + symbol + '\'' +
          '}';
    }

  }
}
