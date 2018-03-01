package com.thread;

public class ThreadDemo01 {

    public static void main(String[] args){
        /*MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");

        //线程的启动是通过start()
        t1.start();
        t2.start();*/

       /* MyRunnable r1 = new MyRunnable("C");
        MyRunnable r2 = new MyRunnable("D");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
*/
       MyRunnable r = new MyRunnable();
       //三个卖票窗口
       Thread t1 = new Thread(r);
       Thread t2 = new Thread(r);
       Thread t3 = new Thread(r);

       t1.start();
       t2.start();
       t3.start();



    }
}
