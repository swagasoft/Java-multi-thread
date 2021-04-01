package com.demo4;


class  Processor extends  Thread{
    int counter = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("Hello " + counter++ );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class App {
    public static  void main (String[] args){
    Processor processor = new Processor();
    processor.start();
    }
}
