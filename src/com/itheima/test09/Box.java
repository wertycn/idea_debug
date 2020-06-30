package com.itheima.test09;

import java.util.LinkedList;

public class Box {
    /**
     * 盒子容量
     */
    private final int MAX_SIZE = 10;
    /**
     * 盒子载体
     */
    private final LinkedList<Object> list = new LinkedList<>();

    public void produce(Object object) {
        System.out.println("生产者" + Thread.currentThread().getName() + "准备生产");
        // 锁定当前对象
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("生产者" + Thread.currentThread().getName() + "发现仓库已满，开始休息");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(Thread.currentThread().getName() + object);
            System.out.println("生产者" + Thread.currentThread().getName() + "生产成功，当前仓库容量" + list.size());
            // 解锁并唤醒其他所有等待线程
            list.notifyAll();
        }
    }

    public void consume() {
        System.out.println("消费者" + Thread.currentThread().getName() + "准备消费");
        // 锁定当前对象
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("消费者" + Thread.currentThread().getName() + "发现仓库空了，开始等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object object = list.remove();
            System.out.println("消费者" + Thread.currentThread().getName() + "消费了" + object + "，当前仓库容量" + list.size());
            // 解锁并唤醒其他所有等待线程
            list.notifyAll();
        }
    }

}
