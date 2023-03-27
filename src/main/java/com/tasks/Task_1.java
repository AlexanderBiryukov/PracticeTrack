package com.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Необходимо реализовать алгоритм, который принимает на вход две коллекции целых чисел и
 * возвращает отсортированную коллекцию, содержащую общие элементы.
 * Пример:
 * [6,4,6,8,1,100,-100], [3,8,76544, -42, 100,1]
 * Результат:
 * [1,8,100]
 */
public class Task_1 {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        al1.add(6);
        al1.add(4);
        al1.add(6);
        al1.add(8);
        al1.add(1);
        al1.add(100);
        al1.add(-100);
        al2.add(3);
        al2.add(8);
        al2.add(76544);
        al2.add(-42);
        al2.add(100);
        al2.add(1);

        System.out.println(searchForIdenticalElements(al1, al2));

    }

    public static ArrayList<Integer> searchForIdenticalElements(Collection<Integer> c1, Collection<Integer> c2) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(c1);
        ArrayList<Integer> arrayList2 = new ArrayList<>(c2);
        ArrayList<Integer> result = new ArrayList<>();

        Collections.sort(arrayList1);
        Collections.sort(arrayList2);

        for (Integer integer : arrayList2) {
            int index = Collections.binarySearch(arrayList1, integer);
            if (index >= 0) {
                result.add(integer);
            }
        }

        return result;
    }
}
