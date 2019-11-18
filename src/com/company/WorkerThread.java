package com.company;

import java.util.ArrayList;

public class WorkerThread extends Thread{
    private ArrayList<Integer> list;
    private int first;
    private int last;
    private int res;
    private int number;

    public WorkerThread(ArrayList x, int first, int last, int number){
        list = x;
        this.first = first;
        this.last = last;
        this.number = number;
    }

    public void run(){
        for (int i = first; i <= last; i++){
            if (list.get(i) == number) res++;
        }
    }

    public int getResult(){
        return res;
    }

}
