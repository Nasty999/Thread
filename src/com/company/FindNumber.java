package com.company;

import java.util.ArrayList;

public class FindNumber {
    private ArrayList<Integer> list;

    public FindNumber(ArrayList list){
        this.list = list;
    }

    public int findSlow(int number){
        int res = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == number) res++;
        }
        return res;
    }

    public int calcOccurenceNum(int number, int threadNum){
        int x = list.size() / threadNum;
        int results = 0;
        WorkerThread[] wt = new WorkerThread[threadNum];
        for (int i = 0; i < threadNum; i++){
            wt[i] = new WorkerThread(list, i*x, (((i+1)*x)-1), number);
            wt[i].start();
        }
        try {
            for (int i = 0; i < threadNum; i++) {
                wt[i].join();
                results += wt[i].getResult();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return results;
    }

}
