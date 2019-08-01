package by.it.group673601.shihalo.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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


        String result = levensteinInstruction(one, two);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private String levensteinInstruction(String s1, String s2) {
        int[][] D = new int[s1.length()+1][s2.length()+1];
        String str = "";
        D[0][0] = 0;
        for (int j = 1; j < s2.length()+1; j++) {
            D[0][j] = D[0][j - 1] + 1;
        }
        for (int i = 1; i < s1.length()+1; i++) {
            D[i][0] = D[i - 1][0] + 1;
            for (int j = 1; j < s2.length()+1; j++) {
                if (s2.charAt(j-1) != s1.charAt(i-1)) {
                    if(D[i - 1][j] + 1 < D[i][j - 1] + 1 && D[i - 1][j] + 1 < D[i - 1][j - 1] + 1) { D[i][j] = D[i - 1][j] + 1; }
                    else {
                        if (D[i][j - 1] + 1 < D[i - 1][j - 1] + 1) { D[i][j] = D[i][j - 1] + 1; }
                        else { D[i][j] = D[i - 1][j - 1] + 1; }
                    }
                } else { D[i][j] = D[i - 1][j - 1]; }
            }
        }

        for(int i = 0; i < s1.length()+1; i++) {
            for(int j = 0; j < s2.length()+1; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(s1+"\n"+s2);
        int i = s1.length(), j = s2.length();
        while(i > 0 || j > 0) {
            if(i == 0 ) { str = str + "," + s2.toCharArray()[j-1] + "+"; j--; }
            else {
                if(j == 0) {str = str + "," + s1.toCharArray()[i-1] + "-"; i--; }
                else {
                    if (D[i][j] - 1 == D[i][j - 1]) { str = str + "," + s2.toCharArray()[j-1] + "+"; j--; }
                    else {
                        if (D[i][j] - 1 == D[i - 1][j - 1]) { str = str + "," + s2.toCharArray()[j-1] + "~"; i--; j--; }
                        else {
                            if (D[i][j] - 1 == D[i - 1][j]) { str = str + "," + s1.toCharArray()[i-1] + "-"; i--; }
                            else {
                                if (D[i][j] == D[i - 1][j - 1]) { str = str + ",#" ; i--; j--; }
                            }
                        }
                    }
                }
            }

        }
        str = new StringBuffer(str).reverse().toString();
        //System.out.println(D[s1.length()][s2.length()]);


        return str;
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
