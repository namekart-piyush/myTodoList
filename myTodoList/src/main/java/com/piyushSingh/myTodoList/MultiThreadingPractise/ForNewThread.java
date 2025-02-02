package com.piyushSingh.myTodoList.MultiThreadingPractise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForNewThread {

    public static void main(String args[]) {
      Counter counter = new Counter();
      MultiThreadExamples t1= new MultiThreadExamples(counter);
        MultiThreadExamples t2= new MultiThreadExamples(counter);
      t1.start();
      t2.start();
       for(int i= 0;i<5; i++){
        log.info(""+counter.getCount());
        }
      try{
          t1.join();
          t2.join();
      }catch (Exception e){
          System.out.println("Not ended");
      }
        System.out.println(counter.getCount());


    }
}
