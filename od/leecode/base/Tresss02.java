package com.leecode.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
宽度搜索
先放根节点，弹出就打印，先左后放右
* */
public class Tresss02 {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public static void main(String[] args) {

    }


    public static List<List<Integer>> checkFun02(TreeNode node) {

        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<>();
        if (node == null) return resList;
        que.offer(node);

        while (!que.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = que.size(); //每一层的数量

            while (len > 0) {
                TreeNode tmpNode = que.poll(); //弹出节点
                list.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left); //先放左
                if (tmpNode.right != null) que.offer(tmpNode.right);//后方右
                len--;
            }
            resList.add(list);
        }
        return resList;
    }


}
