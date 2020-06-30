package com.itheima.test09;

public class Application {
    public static void main(String[] args) {
        // 生产者消费者模型   wait() / notify()方法  实现
        Box box = new Box();
        Thread p1 = new Thread(new Producer(box), "劳模一号");
        Thread p2 = new Thread(new Producer(box), "劳模二号");
        Thread p3 = new Thread(new Producer(box), "劳模三号");
        Thread p4 = new Thread(new Producer(box), "劳模四号");
        Thread p5 = new Thread(new Producer(box), "劳模五号");
        Thread c1 = new Thread(new Comsumer(box), "土豪一号");
        Thread c2 = new Thread(new Comsumer(box), "土豪二号");
        Thread c3 = new Thread(new Comsumer(box), "土豪三号");
        Thread c4 = new Thread(new Comsumer(box), "土豪四号");
        Thread c5 = new Thread(new Comsumer(box), "土豪五号");
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
