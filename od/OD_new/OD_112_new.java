package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/*
* 构建二叉树
* */
class OD_112_new {
    // 二叉树节点及二叉树的定义，常用可记下来
    private static class treeNode {
        int data;
        treeNode left;
        treeNode right;

        public treeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String[] input_infos = in.nextLine().replace("[","").replace("]","").split(",");
        Integer[][] operations = new Integer[input_infos.length/2][2];

        for (int i=0;i<input_infos.length;i++) {
            if (i%2==0){
                operations[i/2][0] = Integer.parseInt(input_infos[i].trim());
                operations[i/2][1] = Integer.parseInt(input_infos[i+1].trim());
            }
        }

        //头节点
        treeNode head = new treeNode(-1);

        ArrayList<treeNode> first_level = new ArrayList<>();
        first_level.add(head);

        ArrayList<ArrayList<treeNode>> tree = new ArrayList<ArrayList<treeNode>>(){{
            add(first_level);
        }};


        for (int i = 0; i < operations.length; i++) {
            int height = operations[i][0];
            int index = operations[i][1];

            // 开启下一层
            if (tree.size() <= height + 1) {
                tree.add(new ArrayList<>());
            }

            treeNode temp_node = new treeNode(i);
            tree.get(height + 1).add(temp_node);

            treeNode parent_node = tree.get(height).get(index);
            if (parent_node.left == null)
                parent_node.left = temp_node;
            else if (parent_node.right == null)
                parent_node.right = temp_node;
        }

        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<treeNode> queue = new LinkedList<>();
        queue.add(tree.get(0).get(0));

        while (queue.size() > 0) {
            treeNode node = queue.removeFirst();

            if (node != null) {
                result.add(node.data);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }

        while (true) {
            if (result.getLast() == null)
                result.removeLast();
            else
                break;
        }

        String output_str = "[";
        for (int i=0;i<result.size();i++) {
            if (result.get(i) == null ) {
                output_str += "null";
            }else {
                output_str += Integer.toString(result.get(i));
            }

            if (i != result.size()-1) {
                output_str += ",";
            }
        }
        output_str+="]";

        System.out.println(output_str);
    }

}