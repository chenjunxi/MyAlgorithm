package com.leecode.base;

import java.util.Stack;
/*
*
 原理就是使用一个进栈和出栈，
添加元素的时候使用进栈
删除元素的使用出栈，如果出栈没有元素的时候，就先把进栈的元素全部加入出栈中
* */
public class MyQueue01 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        for (int i = 1; i <= 10; i++) {
            myQueue.push(i);
        }

        System.out.println(myQueue.size());
//        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.size());

    }
}

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumstackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumstackIn();
        return stackOut.peek();
    }

    public boolean isEmpty() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) {
            return true;
        }

        return false;
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }

    //先判断出栈是否为空，空的时候才进栈
    private void dumstackIn() {
        if (!stackOut.isEmpty()) return;

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
