package com.company;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random ran2 = new Random();
        UsualMatrix m = new UsualMatrix(1000, 1000);
        UsualMatrix m2 = new UsualMatrix(1000, 1000);
        for (int i = 0; i < 1000; i++){
            for (int j = 0; j < 1000; j++){
                m.setElement(i, j, ran2.nextInt(10));
                m2.setElement(i, j, ran2.nextInt(10));
            }
        }

        long start3 = System.currentTimeMillis();
        UsualMatrix res3 = new  ParallelMatrixProduct(4).ParallelMultiply(m, m2);
        long end3 = System.currentTimeMillis();
        System.out.println("Время умножения ParallelMatrixProduct: " + (end3 - start3));
        long start4 = System.currentTimeMillis();
        UsualMatrix res4 = m.product(m2);
        long end4 = System.currentTimeMillis();
        System.out.println("Время умножения UsualMatrix: " + (end4 - start4));

        ArrayList<Integer> list = new ArrayList<>(25000000);
        Random ran = new Random();
        list.add(13);
        list.add(13);
        for (int k = 0; k < 25000000; k++){
            list.add(ran.nextInt(100000));
        }
        FindNumber f = new FindNumber(list);
        long start = System.nanoTime();
        int res1 = f.calcOccurenceNum(13, 4);
        long end = System.nanoTime();
        System.out.println("Многопоточный поиск: " + (end - start));
        long start2 = System.nanoTime();
        int res2 = f.findSlow(13);
        long end2 = System.nanoTime();
        System.out.println("Обычный поиск: " + (end2 - start2));
    }
}
