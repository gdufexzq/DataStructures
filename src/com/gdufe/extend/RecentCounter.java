package com.gdufe.extend;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/2 15:19
 * @version V1.0
 */
public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
