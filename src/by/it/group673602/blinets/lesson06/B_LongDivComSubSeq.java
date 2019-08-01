package by.it.group673602.blinets.lesson06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Задача на программирование: наибольшая кратная подпоследовательность

Дано:
    целое число 1≤n≤1000
    массив A[1…n] натуральных чисел, не превосходящих 2E9.

Необходимо:
    Выведите максимальное 1<=k<=n, для которого гарантированно найдётся
    подпоследовательность индексов i[1]<i[2]<…<i[k] <= длины k,
    для которой каждый элемент A[i[k]] делится на предыдущий
    т.е. для всех 1<=j<k, A[i[j+1]] делится на A[i[j]].

Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ

    Sample Input:
    4
    3 6 7 12

    Sample Output:
    3
*/

public class B_LongDivComSubSeq {


  public static void main(String[] args) throws FileNotFoundException {
    String root = System.getProperty("user.dir") + "/src/";
    InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson06/dataB.txt");
    B_LongDivComSubSeq instance = new B_LongDivComSubSeq();
    int result = instance.getDivSeqSize(stream);
    System.out.print(result);
  }

  int getDivSeqSize(InputStream stream) throws FileNotFoundException {
    //подготовка к чтению данных
    Scanner scanner = new Scanner(stream);
    //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
    //общая длина последовательности
    int n = scanner.nextInt();
    int[] m = new int[n];
    //читаем всю последовательность
    for (int i = 0; i < n; i++) {
      m[i] = scanner.nextInt();
    }
    //тут реализуйте логику задачи методами динамического программирования (!!!)
    int result = 0;

    List<Integer> listResult = new ArrayList();

    for (int i = 0; i < m.length; i++) {
      listResult.add(i, 0);
      for (int j = 0; j < listResult.size() - 1; j++) {
        if (m[i]% m[j] == 0 && listResult.get(j) >= listResult.get(i)) {
          listResult.set(i, listResult.get(j) + 1);
        }
      }
    }
    result = Collections.max(listResult) + 1;

    //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
    return result;
  }


}
