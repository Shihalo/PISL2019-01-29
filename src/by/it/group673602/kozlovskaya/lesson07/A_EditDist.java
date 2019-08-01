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
    Рекурсивно вычислить расстояние редактирования двух данных непустых строк

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

public class A_EditDist {


    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int tmp = 0;
        int[][] mas = new int[one.length()+1][two.length()+1];
        initialFill(mas);

        check(one, two, mas, 0,0);

        int result = mas[one.length()][two.length()];
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private void initialFill(int[][] mas){
        for(int[] e : mas) {
            Arrays.fill(e,0);
        }
        for (int i = 0; i < mas.length; i++){
            mas[i][0] = i;
        }
        for (int i = 1; i < mas[0].length; i++){
            mas[0][i] = i;
        }
    }

    private void check(String one, String two, int[][] mas, int x, int y){
        if (x < one.length()) {
            mas[x + 1][y] = delete(mas, x, y);
            check(one, two, mas, x + 1, y);
        }
        if (y < two.length()) {
            mas[x][y + 1] = insert(mas, x, y);
            check(one, two, mas, x, y + 1);
        }
        if (x < one.length() && y < two.length()) {
            mas[x + 1][y + 1] = replace(one.charAt(x), two.charAt(y), mas, x, y);
            check(one, two, mas, x + 1, y + 1);
        }

    }

    private int delete(int[][] mas, int x, int y){
        if (mas[x+1][y] == 0 || mas[x + 1][y] - mas[x][y] > 1) {
            return mas[x][y] + 1;
        }
        else return mas[x+1][y];
    }

    private int insert(int[][] mas, int x, int y){
        if (mas[x][y+1] == 0 || mas[x][y + 1] - mas[x][y] > 1) {
            return mas[x][y] + 1;
        }
        else return mas[x][y + 1];
    }

    private int replace(char one, char two, int[][] mas, int x, int y){
        if (one != two) {
            if (mas[x+1][y+1] == 0 || mas[x + 1][y + 1] - mas[x][y] > 1) {
                return mas[x][y] + 1;
            }
        }
        else if (mas[x + 1][y + 1] - mas[x][y] > 0){
            return mas[x][y];
        }
        return mas[x + 1][y + 1];
    }




    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        A_EditDist instance = new A_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }
}

