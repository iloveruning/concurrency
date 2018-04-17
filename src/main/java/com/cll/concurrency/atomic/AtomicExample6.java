package com.cll.concurrency.atomic;

import com.cll.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicBoolean
 *
 * @author chenliangliang
 * @date 2018/4/17
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean atomicBoolean=new AtomicBoolean(false);

    public static void main(String[] args) {


    }
}
