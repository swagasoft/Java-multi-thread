package com.demo4;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor2 implements Runnable{

    private  int id;

    public Processor2(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Starting... " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed... " + id);
    }
}


public class Pool {
    public static  void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5 ; i++) {
            executorService.submit( new Processor2(i));
            
        }

        executorService.shutdown();
        System.out.println("all task submitted");
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }catch (InterruptedException e){

        }

    }
}
