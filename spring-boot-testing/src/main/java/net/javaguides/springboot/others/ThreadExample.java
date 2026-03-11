package net.javaguides.springboot.others;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExample{


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();

        RunnableExample runnableExample=new RunnableExample();
        Thread thread=new Thread(runnableExample);
        thread.start();
        
        Thread lambdaExample=new Thread(()-> {
            System.out.println("Thread is running using Lambda Expression");
        });

        lambdaExample.start();

        ExecutorService executorService=new ThreadPoolExecutor(2,2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        executorService.execute(()-> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Thread is running using Executor Service");
        });

        executorService.shutdownNow();

        // create a thread pool with 3 thread and print all the thread names
        
        ExecutorService executorService2=new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

        
        for(int i=0;i<3;i++){
            executorService2.submit(()->{
                System.out.println("Thread Name Print "+Thread.currentThread().getName());
            });
        }
        


        executorService2.shutdown();


        CompletableFuture<String> future=CompletableFuture.supplyAsync(()->{
            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
            return "Hello from supply async method";
        });
        System.out.println(future.get());
        
        future.thenAcceptAsync((result)->{
            try {
                Thread.sleep(20000);
                System.out.println("Print after 2 sec");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        
        


    }

}

class ThreadClass extends Thread{
    public void run() {
        System.out.println("Thread is running using Thread class ");

    }
}

class RunnableExample implements Runnable{

    public void run(){
        System.out.println("Thread is running using Runnable Interface");
    }    
    
}