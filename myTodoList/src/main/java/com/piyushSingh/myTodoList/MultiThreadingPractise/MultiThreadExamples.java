package com.piyushSingh.myTodoList.MultiThreadingPractise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MultiThreadExamples extends Thread{
//concurrent execution is enabled by java multithreading threads share same resorces within a process
//in single core environment Jvm and os manages switching for concurrency,time slicingh is used.
    // through java.lang.Thread class and java.lang.Runnable interface
    // main thread starts on start of jaVA program
    //daemon thread is not waited
    private Counter counter;
    public MultiThreadExamples(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run(){
       for(int i=0;i<1000;i++){
            counter.incr();
            System.out.println("Incremeted");

        }
    }

}
