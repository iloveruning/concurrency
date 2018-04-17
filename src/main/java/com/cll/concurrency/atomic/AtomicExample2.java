package com.cll.concurrency.atomic;

import com.cll.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {

    private static AtomicReference<Integer> count=new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,1);
        log.info(count.get().toString());
        count.compareAndSet(1,3);
        log.info(count.get().toString());
        count.compareAndSet(1,2);
        log.info(count.get().toString());
        count.compareAndSet(3,9);
        log.info(count.get().toString());
    }
}
