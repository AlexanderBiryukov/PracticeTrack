package com.tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task3_2 {
    public static void main(String[] args) {
        Foo1 foo1 = new Foo1();
        Runnable r1 = foo1::first;
        Runnable r2 = foo1::second;
        Runnable r3 = foo1::third;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        scheduledExecutorService.schedule(r1, 100, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(r2, 200, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(r3, 300, TimeUnit.MILLISECONDS);
        scheduledExecutorService.shutdown();
    }
}

class Foo1 {

    public void first() {
        System.out.print("first");
    }

    public void second() {
        System.out.print("second");
    }

    public void third() {
        System.out.print("third");
    }
}