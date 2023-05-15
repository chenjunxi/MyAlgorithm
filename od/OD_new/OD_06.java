package com.od.OD.OD130;

import java.util.*;

/*单链表中间节点
00100 4  头节点地址 4个元素
00000 4 -1 节点地址 值 下一个节点地址 -1表示是尾节点
00100 1 12309
33218 3 00000
12309 2 33219

利用map知识点
 * */
public class OD_06 {
    public static class Node {
        String data;
        String next;

        public Node(String data, String next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 通过map快速寻址
        Map<String, Node> map = new HashMap<>();
        Scanner in = new Scanner(System.in);

        // 初始化元信息和具体数据
        String[] mate = in.nextLine().split(" ");
        for (int i = 0; i < Integer.parseInt(mate[1]); i++) {
            String[] info = in.nextLine().split(" ");
            map.put(info[0], new Node(info[1], info[2]));
        }

        // 因为存在为空的数据，通过list保存有效数据和记录数据链长度
        List<String> res = new LinkedList<>();
        String address = mate[0];
        while (true) {
            if (!map.containsKey(address)) {
                break;
            }
            // 记录当前节点，并指向下一个节点
            Node node = map.get(address);
            res.add(node.data);
            address = node.next;
        }

        // 返回中间第二个（如果有）的值
        int idx = (res.size()) / 2;
        System.out.println(res.get(idx));


    }
}
