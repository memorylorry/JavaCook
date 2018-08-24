# ThreadPool
### Construction method
We will learn Java thread pool in this section. Firstly, we should know java.util.concurrent.ThreadPoolExecutor some details(You could open one Java project to look its cocde.). Here displays its 4 construction methods in the next code.
```
package java.util.concurrent;

public class ThreadPoolExecutor extends AbstractExecutorService {
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {}
                              
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {}
                              
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler) {}
                              
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {}
}
```
**corePoolSize:** The number of threads to keey in the pool, even if they are idle, unless allowCoreThreadTimeOut is set.

**maximumPoolSize:** The max number of threads to be allowed in the pool.

**keepAliveTime:** When threads number is greater than corePoolSize. this is the maximum time that excess idle threads will wait for new tasks before terminating.

**unit:** The unit of keepAliveTime.

**workQueue:** the queue to use for holding tasks before they are executed.  This queue will hold only the {@code Runnable} tasks submitted by the {@code execute} method.

**threadFactory:** the factory to use when the executor creates a new thread

**handler:** the handler to use when execution is blocked because the thread bounds and queue capacities are reached

### Simle example
This sample create pool, and create many tasks to be handled.
```
public class Sample {
    public static void main(String args[]) throws InterruptedException {
        //create one thread pool
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 4, 
                                                             TimeUnit.SECONDS,
                                                             new ArrayBlockingQueue<Runnable>(90));
        for(int i=0;i<100;i++){
            MyRunnable task = new MyRunnable();
            //execute given tasks in future
            executor.execute(task);
        }
        executor.shutdown();
    }
}
```
I find it easy to meet one RejectedExecutionException when **maximumPoolSize+workQueueLength<the number of tasks**. Why is that? Let watch next.
### Pool structure

### Excute method
