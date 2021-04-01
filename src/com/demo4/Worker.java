package com.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
    private Random random =  new Random();

    public List<Integer> list1 =  new ArrayList<Integer>();
    public List<Integer> list2 =  new ArrayList<Integer>();

    public  void stageOne(){

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list2.add(random.nextInt(100));
    }

    public  void stageTwo(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list1.add(random.nextInt(100));
    }



  public  void process(){
      for (int i = 0; i < 1000; i++) {
    stageOne();
    stageTwo();
      }
  }


    public  void main(){
        System.out.println("Starting ....");
        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();

        System.out.println("time taken  " + (end - start));
        System.out.println(list1.size());
        System.out.println(list2.size());
    }

}
