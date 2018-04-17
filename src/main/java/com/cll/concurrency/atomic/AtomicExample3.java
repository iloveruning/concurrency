package com.cll.concurrency.atomic;

import com.cll.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {

    private static AtomicIntegerFieldUpdater<AtomicExample3> updater=AtomicIntegerFieldUpdater.newUpdater(AtomicExample3.class,"count");

    @Getter
    private volatile int count=0;

    public static void main(String[] args) {
        AtomicExample3 example3 = new AtomicExample3();
        if ( updater.compareAndSet(example3,0,1)){
            log.info("success: "+updater.get(example3));
        }else {
            log.info("fail: "+updater.get(example3));
        }
        if ( updater.compareAndSet(example3,0,2)){
            log.info("success: "+updater.get(example3));
        }else {
            log.info("fail: "+updater.get(example3));
        }
        if ( updater.compareAndSet(example3,1,4)){
            log.info("success: "+updater.get(example3));
        }else {
            log.info("fail: "+updater.get(example3));
        }
        if ( updater.compareAndSet(example3,4,9)){
            log.info("success: "+updater.get(example3));
        }else {
            log.info("fail: "+updater.get(example3));
        }


    }
}
