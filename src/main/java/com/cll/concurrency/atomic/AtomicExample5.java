package com.cll.concurrency.atomic;

import com.cll.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * AtomicLongArray
 *
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicLongArray atomicLongArray=new AtomicLongArray(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            atomicLongArray.set(i,i*i);
        }


        for (int i = 0; i < 5; i++) {
            if (atomicLongArray.compareAndSet(i,i,i+1)){
                log.info("success: "+atomicLongArray.get(i));
            }else {
                log.error("fail: "+atomicLongArray.get(i));
            }
        }

    }
}
