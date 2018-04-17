package com.cll.concurrency.atomic;

import com.cll.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampReference 解决 ABA问题
 *
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(0,0);

    @Getter
    private volatile int count=0;

    public static void main(String[] args) {
        AtomicExample4 example3 = new AtomicExample4();
        if ( atomicStampedReference.compareAndSet(0,1,0,1)){
            log.info("success: "+atomicStampedReference.getReference());
        }else {
            log.info("fail: "+atomicStampedReference.getReference());
        }
        if ( atomicStampedReference.compareAndSet(0,1,0,1)){
            log.info("success: "+atomicStampedReference.getReference());
        }else {
            log.info("fail: "+atomicStampedReference.getReference());
        }
        if ( atomicStampedReference.compareAndSet(1,2,0,1)){
            log.info("success: "+atomicStampedReference.getReference());
        }else {
            log.info("fail: "+atomicStampedReference.getReference());
        }
        if ( atomicStampedReference.compareAndSet(0,1,0,1)){
            log.info("success: "+atomicStampedReference.getReference());
        }else {
            log.info("fail: "+atomicStampedReference.getReference());
        }


    }
}
