package com.tasks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Задание
 * Дан класс:
 * public class Foo {
 * public void first(Runnable r) { print("first"); }
 * public void second(Runnable r) { print("second"); }
 * public void third(Runnable r) { print("third"); }
 * }
 * Один и тот же экземпляр данного класса будет вызван 3мя разными потоками.
 * Поток А - будет вызывать метод first(). Поток B - second(). Поток С - third().
 * Необходимо реализовать механизм и изменить программу таким образом,
 * что методы класса Foo будут вызваны в правильном порядке.
 * Пример:
 * Вывод: "firstsecondthird"
 * Мы не знаем, в каком порядке будут вызваны методы, но должны гарантировать порядок.
 */
public class Task3_1 {

    public static void main(String[] args) {
        Foo foo = new Foo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(foo::first);
        executorService.submit(foo::second);
        executorService.submit(foo::third);

        executorService.shutdown();

    }
}

class Foo {
    Semaphore semSecond = new Semaphore(0);
    Semaphore semThird = new Semaphore(0);

    public void first() {
        System.out.print("first");
        semSecond.release();
    }

    public void second() {
        try {
            semSecond.acquire();
            System.out.print("second");
            semThird.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void third() {
        try {
            semThird.acquire();
            System.out.print("third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}