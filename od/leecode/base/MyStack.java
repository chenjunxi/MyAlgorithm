package com.leecode.base;

import java.util.LinkedList;
import java.util.Queue;

/*
*
原理：栈是先进后出，队列是先进先出，使用队列实现栈，就相当于把队列后面的元素放在队列第一位

通过弹出再追加到队列中，进过size-1次，这样就把后面的元素跑到前面来
* */
public class MyStack {


    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }


    public void push(int x) {
        queue.add(x);
    }


    public int pop() {
        int size = queue.size();
        size--;
        while (size-- > 0) {
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

}

