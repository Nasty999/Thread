package com.company;

public class NewThread extends Thread{
    private int[] a;
    private UsualMatrix matrix;
    //private int column;
    private int[] res;

    public NewThread(int[] a, UsualMatrix matrix){
        this.a = a;
        this.matrix = matrix;
        res = new int[a.length];
    }

    public void run(){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < matrix.column; j++) {
                res[j] += a[i] * matrix.getElement(i, j);
            }
        }
    }

    public int[] getResult(){
        return res;
    }


}
