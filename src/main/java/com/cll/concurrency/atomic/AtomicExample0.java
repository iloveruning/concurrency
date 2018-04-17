package com.cll.concurrency.atomic;

import com.cll.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
@ThreadSafe
public class AtomicExample0 {

    private static int clientTotal=5000;

    private static int threadTotal=200;

    private static AtomicLong count=new AtomicLong(0);


    public static void main(String[] args) throws Exception{
        ExecutorService threadPool = Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadTotal);
        final CountDownLatch latch=new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            threadPool.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }

            });
            latch.countDown();
        }
        latch.await();
        //threadPool.shutdown();
        log.info("count: {}",count.get());
    }


    private static void add() {
        count.incrementAndGet();
    }
}
