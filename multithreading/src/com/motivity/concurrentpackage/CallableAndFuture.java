package com.motivity.concurrentpackage;

import java.util.concurrent.*;

class Counter implements Callable<Integer>
{
    private  int number;

    public Counter(int number) {
        this.number = number;
    }
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=0;i<number;++i)
        {
            sum=sum+i;
        }
        return sum;
    }
}
public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "my task1 is done";
            }
         };
        ExecutorService executorService= Executors.newSingleThreadExecutor();

      Future<String>  future =executorService.submit(task);
        executorService.awaitTermination(100,TimeUnit.MILLISECONDS);
      if(future.isDone())
      {
          System.out.println("task : "+future.get());
      }
      else{
          System.out.println("not done");
      }
      Counter counter=new Counter(10);
     Future<Integer> future1= executorService.submit(counter);
        System.out.println("task2 : counting is done "+future1.get());
     executorService.shutdown();
    }
}
