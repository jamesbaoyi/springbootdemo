package com.baoyi.springbootdemo.controller;

import java.util.Random;
import java.util.concurrent.*;

public class ForkJoinPoolController {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        PrintTask task = new PrintTask(0, 300);
//        //创建实例，并执行分割任务
//        ForkJoinPool pool = new ForkJoinPool(256);
//        pool.invoke(task);
//        //线程阻塞，等待所有任务完成
//        pool.awaitTermination(2, TimeUnit.SECONDS);
//        pool.shutdown();


        int[] arr = new int[100];
        Random random = new Random();
        int total = 0;
        //初始化100个数组元素
        for (int i = 0, len = arr.length; i < len; i++) {
            int temp = random.nextInt(20);
            //对数组元素赋值，并将数组元素的值添加到sum总和中
            total += (arr[i] = temp);
        }
        System.out.println("初始化数组总和：" + total);
        SumTask sumTask = new SumTask(arr, 0, arr.length);
//        创建一个通用池，这个是jdk1.8提供的功能
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> future = forkJoinPool.submit(sumTask); //提交分解的SumTask 任务
        System.out.println("多线程执行结果：" + future.get());
        forkJoinPool.shutdown(); //关闭线程池
    }


    public static class PrintTask extends RecursiveAction {

        private static final int THRESHOLD = 50;
        private int start;
        private int end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + "的i值：" + i);
                }
            } else {
                int middle = (start + end) / 2;
                PrintTask left = new PrintTask(start, middle);
                PrintTask right = new PrintTask(middle, end);
                //并行执行两个“小任务”
                left.fork();
                right.fork();
            }
        }
    }

    static class SumTask extends RecursiveTask<Integer> {

        private static final int THRSEHOLD = 20;

        private int array[];

        private int start;

        private int end;

        public SumTask(int[] array, int start, int end) {
            super();
            this.array = array;
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {
            int sum = 0;
            //当end与start之间的差小于threshold时，开始进行实际的累加
            if (end - start < THRSEHOLD) {
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {//当end与start之间的差大于threshold，即要累加的数超过20个时候，将大任务分解成小任务
                int middle = (start + end) / 2;
                SumTask left = new SumTask(array, start, middle);
                SumTask right = new SumTask(array, middle, end);
                //并行执行两个 小任务
                left.fork();
                right.fork();
                //把两个小任务累加的结果合并起来
                return left.join() + right.join();
            }

        }
    }
}

