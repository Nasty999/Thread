package com.company;

public class ParallelMatrixProduct extends Thread {
    private int numberOfThreads;

    public ParallelMatrixProduct(int numberOfThreads){
        this.numberOfThreads = numberOfThreads;
    }

    public UsualMatrix ParallelMultiply(UsualMatrix m1, UsualMatrix m2){
        UsualMatrix result = new UsualMatrix(m1.row, m2.column);
        if (result.row < numberOfThreads)
            numberOfThreads = result.row;
        NewThread[] thread = new NewThread[numberOfThreads];
        int k = 0;
        while (k < result.row) {
            for (int i = 0; i < numberOfThreads; i++, k++) {
                if (k == result.row) {
                    numberOfThreads = i;
                    break;
                }
                thread[i] = new NewThread(m1.matrix[k], m2);
                thread[i].start();
            }
            try {
                for (int i = 0; i < numberOfThreads; i++) {
                    thread[i].join();
                    result.matrix[i + k - numberOfThreads] = thread[i].getResult();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

