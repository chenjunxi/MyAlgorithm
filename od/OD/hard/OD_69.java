package com.od.OD.bei;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/*查找二叉树节点/查找树中元素

输入
6
10 1 2  表示根节点的值为10，根节点的子节点在索引1(就是第二行的-21 3 4)和2(就是第三行的23 5)
-21 3 4
23 5
14
35
66
1 1 查找（1,1）坐标对应的值
构成二叉树之后
输出{23}
 * */
class OD_69 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        int[][] nodes = new int[size][];
        for (int i = 0; i < size; i++) {
            nodes[i] = parseOneLine(in.nextLine());
        }
        int[] xy = parseOneLine(in.nextLine());
        String result = doQuery(nodes, xy[0], xy[1]);
        System.out.println(result);
    }

    private static int[] parseOneLine(String text) {
        ByteArrayInputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        Scanner in = new Scanner(stream);
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.nextInt());
        }
        return list.stream().mapToInt(it -> it).toArray();
    }

    private static String doQuery(int[][] nodes, int x, int y) {
        if (x < 0 || y < 0) {
            return "{}";
        }

        List<Integer> list = new ArrayList<>();
        handle(nodes, 0, x, list);

        if (y >= list.size()) {     //所在层数子节点不足y+1个
            return "{}";
        }

        return "{" + list.get(y) + "}";
    }

    /**
     * 求出n层所有数据并加入list集合中
     *
     * @param nodes 节点信息二维数组
     * @param index 子节点索引
     * @param n     树的层数递减（遍历几次代表几层）
     * @param list  所求层的所有数据集合
     */
    private static void handle(int[][] nodes, int index, int n, List<Integer> list) {

        int[] node = nodes[index];
        if (n == 0) {   //表示已经到了所求层数
            list.add(node[0]);
            return;
        }

        if (node.length == 1) {     //说明没有子节点
            return;
        }

        for (int i = 1; i < node.length; i++) {     //各数组中的0元素代表其值，后面的代表其子节点，所有从1开始遍历
            handle(nodes, node[i], n - 1, list);
        }
    }
}