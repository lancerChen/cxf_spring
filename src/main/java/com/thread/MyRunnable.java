package com.thread;

public class MyRunnable implements Runnable {

    private int ticket =5;
    @Override
    public void run() {
        for (int i=0; i<10;i++){
            synchronized (this){ //同步块，需要资源共享时使用(会减慢执行速度)
                if (ticket>0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("车票 : "+ ticket--);
                }
           }

        }
    }

   /* private String name ;
    public MyRunnable(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println(name+" : "+i);
        }

    }*/
}
