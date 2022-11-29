package com.neuedu.order.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ticket implements Runnable{
    private static int count;

    public Ticket(int count){
        this.count= count;
    }

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) { //加上同步代码块让卖票行为是同步的，当一个线程执行时，让其它线程等待
                if (count > 0) {
                    count--;
                    System.out.println(Thread.currentThread().getName() + "已卖出1张票,总票数还剩" + count + "张票");
                }
            }

        }
    }

    public static void main(String[] args) {
        // 使用阿里巴巴推荐的创建线程池的方式
        // 通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行Runnable
        Runnable ticket = new Ticket(100);
        for (int i = 0; i < 10; i++) {
            executor.execute(ticket);
        }
        // 终止线程池
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println("=====Finish All Threads=====");
    }
}
