package com.leecode.base;

import java.util.ArrayDeque;
import java.util.Arrays;
//单调递增队列
public class MyStack05 {
    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] demo = demo(nums, 3);
        System.out.println(Arrays.toString(demo));
    }

    public static int[] demo(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            //如果进来的元素比队列最后的元素大，那么就要删掉最后一个元素，删掉元素不小于进来的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }

        }

        return res;
    }
}
