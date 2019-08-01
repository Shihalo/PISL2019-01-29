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

    String getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int[][] mas = new int[one.length()+1][two.length()+1];

        initialFill(mas);

        populateMas(mas, one, two);

        String[] operations = comeBack(mas, one, two);

        String result = reverse(operations);

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private void initialFill(int[][] mas){
        for(int[] e : mas){
            Arrays.fill(e, 0);
        }
        for (int i =1; i < mas[0].length; i++){
            mas[0][i] = i;
        }
        for (int i =0; i < mas.length;i++){
            mas[i][0] = i;
        }
    }

    private void populateMas(int[][] mas, String one, String two) {
        for (int i = 1; i < mas.length; i++){
            for (int j = 1; j < mas[i].length; j++){
                mas[i][j] = check(one.charAt(i-1), two.charAt(j-1),mas, i, j);
            }
        }
    }

    private int check(char one, char two, int[][] mas, int i, int j){
        int min;
        if (mas[i-1][j] < mas[i][j-1]){
            min = mas[i-1][j] + 1;
        }
        else min = mas[i][j-1] + 1;

        if (one != two){
            if (min > mas[i-1][j-1] + 1){
                min = mas[i-1][j-1] + 1;
            }
        }
        else if (min > mas[i-1][j-1]){
            min = mas[i-1][j-1];
        }
        return min;
    }

    private String[] comeBack(int[][] mas, String one, String two){
        StringBuilder buf = new StringBuilder();
        int x = mas.length-1;
        int y = mas[0].length-1;
        while (x > 0 || y > 0){
            if (x > 0 && y > 0 && mas[x-1][y-1] == mas[x][y] && one.charAt(x-1) == two.charAt(y-1)) {
                buf.append("#,");
                x--; y--;
                continue;
            }
            if (x > 0 && y > 0 && mas[x][y] - mas[x-1][y-1] == 1 && one.charAt(x-1) != two.charAt(y-1)){
                buf.append("~");
                buf.append(two.charAt(y-1));
                buf.append(",");
                x--; y--;
                continue;
            }
            if (x > 0 && mas[x][y] - mas[x-1][y] == 1){
                buf.append("-");
                buf.append(one.charAt(x-1));
                buf.append(",");
                x--;
                continue;
            }
            if (y > 0 && mas[x][y] - mas[x][y-1]== 1){
                buf.append("+");
                buf.append(two.charAt(y-1));
                buf.append(",");
                y--;
            }
        }
        return buf.toString().split(",");
    }

    private String reverse(String[] operations){
        StringBuilder buf = new StringBuilder();
        for (int i = operations.length - 1; i >= 0; i--){
            buf.append(operations[i]);
            buf.append(",");
        }
        return buf.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        C_EditDist instance = new C_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}