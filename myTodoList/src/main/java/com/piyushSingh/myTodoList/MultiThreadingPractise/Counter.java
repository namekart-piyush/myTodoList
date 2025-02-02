package com.piyushSingh.myTodoList.MultiThreadingPractise;

public class Counter {
    private int count = 0;

    public void incr(){
        synchronized (this){
            count++;
        }

    }

    public int getCount() {
        return count;
    }

}
