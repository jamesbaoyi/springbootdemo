package com.baoyi.springbootdemo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTestController {

    public static void main(String[] args) {
        List<String> students = new CopyOnWriteArrayList<>();
        students.add("张三");
        students.add("李四");
        students.add("王五");
        students.add("赵六");
        students.add("张军");
//        students.add("李四");
//        students.add("李四");
//        students.add("李四");

//        for (String temp : students) {
//            if (Objects.equals(temp, "李四")) {
//                students.remove(temp);
//            }
//        }
//        for (int i = students.size() - 1; i >= 0; i--) {
//
//            if (students.get(i).equals("李四")) {
//                students.remove(i);
//
//            }
//
//        }
        Thread thread1 = new Thread(() -> {
            for (int i = students.size() - 1; i >= 0; i--) {
                if (students.get(i).equals("李四")) {
                    students.remove(i);
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            Iterator<String> iterator = students.iterator();
            while (iterator.hasNext()) {
                System.out.println("线程2获取的数据" + iterator.next());
            }
        });

        thread1.start();
        thread2.start();


    }

}
