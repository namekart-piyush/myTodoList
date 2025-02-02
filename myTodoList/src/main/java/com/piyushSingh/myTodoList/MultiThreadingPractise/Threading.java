package com.piyushSingh.myTodoList.MultiThreadingPractise;

//readlock and writelock
//wait ,notifyAll,notify

class SharedResource{
    private int data;
    private boolean hasData;

    public synchronized void produce(int i){

        while(hasData){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = i;
        hasData = true;
        System.out.println("Produced"+i);
        notify();

    }
    public synchronized  int consume(){
        while(!hasData){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("OK");
        notifyAll();
        return data;

    }

}
public class Threading {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(new Producer(sharedResource));
        Thread t2 = new Thread(new Consumer(sharedResource));
        t1.start();
        t2.start();
    }
}

class Producer implements Runnable{

    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            sharedResource.produce(i);

        }
    }
}
class Consumer implements Runnable{
  private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource=sharedResource;
    }

    @Override
    public void run() {
        for(int i =0;i<10;i++){
            sharedResource.consume();

        }
    }
}

