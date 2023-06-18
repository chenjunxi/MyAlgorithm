package com.leecode;

public class Leetcode002 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public static ListNode addTwo(ListNode l1, ListNode l2) {


        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        ListNode cur01 = l1;
        ListNode cur02 = l2;

        while (cur01 != null) {
            a.append(cur01.val);
            cur01 = cur01.next;
        }

        while (cur02 != null) {
            b.append(cur02.val);
            cur02 = cur02.next;
        }

        int i = Integer.valueOf(a.reverse().toString()) + Integer.valueOf(b.reverse().toString());

        return null;
    }

}
