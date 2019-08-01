package by.it.group673602.khovanskaya.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        if(n<2){
            return BigInteger.ONE;
        }
        BigInteger[] rememberfibo = new BigInteger[n];
        rememberfibo[0] = rememberfibo[1] = BigInteger.ONE;
        for(int i=2; i<n; i++) {
            rememberfibo[i] = rememberfibo[(i - 1)].add(rememberfibo[(i - 2)]);
        }
        return rememberfibo[n-1];
    }

}

