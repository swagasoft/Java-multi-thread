package com.demo4;

public class Work {
private int count = 0;

public synchronized void increment(){
    count ++;
}

    public static  void main(String[] args){
        Work work =  new Work();
        work.doWork();
    }

    public void doWork(){
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i ++){
               increment();
                System.out.println(" value of count1 " + count);
            }
        }
    });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i ++){
                   increment();
                    System.out.println(" value of count2 " + count);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" count is  "+ count);
    }
}

