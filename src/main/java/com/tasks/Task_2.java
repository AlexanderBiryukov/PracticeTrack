package com.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Необходимо реализовать анализатор текста,
 * который принимает строку и проверяет, что у неё закрыты все открытые скобки
 * Пример:
 * “[({})]” - корректно
 * “[(){}” - не корректно
 */

public class Task_2 {
    public static void main(String[] args) {
        String test1 = "[({})]";
        String test2 = "[(){}";
        textAnalyzer(test1);
        textAnalyzer(test2);
    }

    public static void textAnalyzer(String str) {
        String[] arrStr = str.split("");

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        if (arrStr.length % 2 == 0) {

            for (int i = 0; i < arrStr.length; i++) {
                String e = arrStr[i];

                if (e.equals("{") || e.equals("[") || e.equals("(")) {
                    arrayDeque.push(e);
                } else if (e.equals("}") || e.equals("]") || e.equals(")")) {
                    if (arrayDeque.isEmpty()) {
                        System.out.println("не корректно");
                    }
                    String k = arrayDeque.pop();
                    if ((e.equals("}") && k.equals("{")) || (e.equals(")") && k.equals("(")) || (e.equals("]") && k.equals("["))) {
                        continue;
                    } else {
                        System.out.println("не корректно");
                    }
                }
            }
            System.out.println(arrayDeque.isEmpty() ? "корректно" : "не корректно");

        } else {
            System.out.println("не корректно");
        }
    }
}
