package by.it.group673602.kozlovskaya.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class B_EditDist {


    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int[] mas = new int[two.length()+1];

        initialFill(mas);

        int prev = 0,tmp;
        for(int i = 1; i < one.length()+1; i++){
            prev = i;
            for (int j = 1; j < mas.length; j++){
                tmp = check(one.charAt(i-1), two.charAt(j-1),mas, j, prev);
                mas[j-1] = prev;
                prev = tmp;
            }
        }


        int result = prev;
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private void initialFill(int[] mas){
        for (int i = 0; i < mas.length; i++){
            mas[i] = i;
        }
    }

    private int check(char one, char two, int[] mas, int i, int prev){
        int min;
        if (mas[i] < prev){
            min = mas[i] + 1;
        }
        else min = prev + 1;
        if (one != two){
            if (min > mas[i-1] + 1){
                min = mas[i-1] + 1;
            }
        }
        else if (min > mas[i-1]){
            min = mas[i-1];
        }
        return min;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        B_EditDist instance = new B_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}