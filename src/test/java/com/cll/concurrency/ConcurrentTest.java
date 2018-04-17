package com.cll.concurrency;

import com.cll.concurrency.annotation.ThreadUnSafe;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
public class ConcurrentTest {

    private int clientTotal=5000;

    private int threadTotal=200;

    private int count=0;


    @Test
    @ThreadUnSafe
    public void test0() throws InterruptedException {
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
        threadPool.shutdown();
        log.info("count: {}",count);
    }

    private void add() {
        this.count++;
    }

}
