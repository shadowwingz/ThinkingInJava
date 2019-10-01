package chapter21;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shadowwingz on 2018-07-24 19:44
 *
 * Runnable 不返回值
 * Callable 会返回值
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    // call 方法中执行任务逻辑，然后返回一个值，值的类型是 Callable 的泛型。
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        /**
         * submit 方法会产生 Future 对象
         */
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            try {
                /**
                 * 调用 get 方法取出 Callable 任务的返回值，
                 * get 方法会等待 Callable 的 call 方法执行完，
                 * 也就是说，call 方法执行完，get 方法才有返回值，
                 * call 方法没有执行完，程序就阻塞在 get 方法这里。
                 */
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}

/*
输出：

result of TaskWithResult 0
result of TaskWithResult 1
result of TaskWithResult 2
result of TaskWithResult 3
result of TaskWithResult 4
result of TaskWithResult 5
result of TaskWithResult 6
result of TaskWithResult 7
result of TaskWithResult 8
result of TaskWithResult 9

 */