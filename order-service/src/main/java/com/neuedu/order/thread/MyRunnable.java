package com.neuedu.order.thread;

import java.util.Date;
import java.util.function.Supplier;

/**
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务
 */
public class MyRunnable implements Runnable{

    private Integer count;

//    ThreadLocal local = new ThreadLocal<Integer>();

    // 初始化变量
    ThreadLocal<Integer> local = ThreadLocal.withInitial(
            new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return count;
                }
            }
    );

    public MyRunnable(Integer count) {
        this.count = count;
    }

    @Override
    public void run() {
        processCommand();
    }


    private void processCommand() {
        try {
            while (local.get() > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    if (local.get() > 0) {
                        local.set(local.get() - 1);;
                        System.out.println(Thread.currentThread().getName() +
                                "已卖出1张票,总票数还剩" + local.get() + "张票");
                    }
            }
//            local.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "count=" + count +
                '}';
    }
}
