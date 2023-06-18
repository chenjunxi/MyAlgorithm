package com.leecode.base;

import org.apache.flink.table.expressions.In;

import java.util.*;


//递归遍历树
//迭代
public class Tree001<TreeNode1> {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
    }

    //参数和返回值,前序：中左右
    public static void preorder(TreeNode root, ArrayList<Integer> list) {

        //终止条件
        if (root == null) return;

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);


    }

    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    public static List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;

    }


    //    中序遍历：左中右
    public static void inorder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }

    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    //先把左子树全部压进stack
    //压完左树，栈开始一个个弹出(就操作弹出的节点)，如果元素有右树，再把右树下的左子树全部压入，重复循环这个流程
    public static List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.poll();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;

    }

    //    后序遍历：左右中
    public static void postorder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) return;

        preorder(root.left, list);
        preorder(root.right, list);
        list.add(root.val);

    }

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);

        return list;
    }
}
