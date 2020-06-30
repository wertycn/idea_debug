package com.hdmin.test09;

/**
 * 消费者
 */
public class Comsumer implements Runnable {
    private Integer sleep = 500;
    private Box box;

    public Comsumer() {
    }

    public Comsumer(Box box) {
        this.box = box;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            this.box.consume();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者" + Thread.currentThread().getName() + "消费过多，已经破产。。。。。。");
    }
}
