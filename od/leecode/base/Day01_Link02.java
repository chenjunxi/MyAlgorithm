package com.leecode.base;

public class Day01_Link02 {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {
        int size;

        Node head;

        public MyLinkedList() {
            size = 0;
            head = new Node(0);
        }

        //获取第index个节点的数值

        public int get(int index) {

            if (!isIndex(index) || size == 0) return -1;

            Node cur = head;

            while (index == 0 || cur != null) {
                cur = cur.next;
                index--;

            }

            return cur.val;
        }


        //在表头添加节点
        public void addAtHead(int val) {

            addAtInde(0, val);
        }

        //在表尾添加节点
        public void addAtTail(int val) {

            addAtInde(size, val);
        }

        //指定位置添加节点
        public void addAtInde(int val, int index) {
            if (!isIndex(index)) return;

            size++;
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }

            Node node = new Node(val);
            node.next = cur.next;
            cur.next = node;

        }


        //删除第index个节点
        public void deleteIndex(int val, int index) {

            if (!isIndex(index)) return;


            if (index == 0) {
                head = head.next;
                return;
            }

            Node pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }


            pre.next = pre.next.next;

        }


        public int getSize() {

            return size;
        }


        //检验索引的合法
        public boolean isIndex(int index) {

            if (index < 0 || index > size) {
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {

    }
}
