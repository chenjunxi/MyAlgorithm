package com.od.B.fenshu200;


import java.util.Scanner;

/*
查找字符串在二维数组中的坐标
4
A,C,C,F
C,D,E,D
B,E,S,S
F,E,C,A
ACCESS

输出：0,0,0,1,0,2,1,2,2,2,2,3
4
A,F,C,F
C,D,E,D
B,E,S,S
F,C,C,A
ACCESS
输出：3,3,3,2,3,1,2,1,2,2,2,3
难点是相邻单元格，即是坐标形成贪吃蛇
ACC
  E
  SS

思路：
先对第一个字符作为入口点，每一次都复制一份临时二维组
然后dfs深度上下左右递归，试过的位置置空，如果递归失败，还原位置的值

其实就是复杂版的dfs

dfs(){
四种情况，只有一种满足条件

}
* */
public class OD06 {


    public static int n;
    public static int slen;
    public static String res;
    public static String inputS;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        String[][] strings = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputStrings = sc.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                strings[i][j] = inputStrings[j];
            }
        }

        inputS = sc.nextLine();
        slen = inputS.length();
        String first = String.valueOf(inputS.charAt(0));//从第一个值开始
        boolean isSuccess = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (strings[i][j].equals(first)) {
                    String[][] temp = copy(strings);    //对数组进行复制，否则影响第二次计算
                    res = i + "," + j;
                    temp[i][j] = ""; //已取出的值置空
                    if (dfs(1, i, j, temp)) { //表示已经成功取出数据
                        isSuccess = true;
                        System.out.println(res);
                        break;
                    }
                }
            }
            if (isSuccess) {
                break;
            }
        }
        if (!isSuccess) {
            System.out.println("N");
        }


    }


    public static String[][] copy(String[][] strings) {
        int x = strings.length;
        String[][] copyS = new String[x][x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                copyS[i][j] = strings[i][j];
            }
        }
        return copyS;
    }

    public static boolean dfs(int index, int row, int col, String[][] temp) {

        if (index == slen) {  //终止条件
            return true;
        }

        for (int i = index; i < inputS.length(); i++) {
            String s = String.valueOf(inputS.charAt(index));

            if (row > 0 && temp[row - 1][col].equals(s)) {    //对上边的字符串进行比较
                temp[row - 1][col] = "";  //将已经取出的字符串进行置空，防止多次取值
                String str = "," + (row - 1) + "," + col;
                res += str;    //添加坐标
                if (dfs(i + 1, row - 1, col, temp)) { //值为1表示成功取出
                    return true;
                } else {
                    res = res.substring(0, res.length() - str.length());  //如果失败则进行还原
                    temp[row - 1][col] = s;
                }
            }

            if (col > 0 && temp[row][col - 1].equals(s)) {  // 左边
                temp[row][col - 1] = "";
                String str = "," + row + "," + (col - 1);
                res += str;
                if (dfs(i + 1, row, col - 1, temp)) {
                    return true;
                } else {
                    res = res.substring(0, res.length() - str.length());
                    temp[row][col - 1] = s;
                }
            }

            if (row < n - 1 && temp[row + 1][col].equals(s)) {    //下边
                temp[row + 1][col] = "";
                String str = "," + (row + 1) + "," + col;
                res += str;
                if (dfs(i + 1, row + 1, col, temp)) {
                    return true;
                } else {
                    res = res.substring(0, res.length() - str.length());
                    temp[row + 1][col] = s;
                }
            }

            if (col < n - 1 && temp[row][col + 1].equals(s)) {    //右边
                temp[row][col + 1] = "";
                String str = "," + row + "," + (col + 1);
                res += str;
                if (dfs(i + 1, row, col + 1, temp)) {
                    return true;
                } else {
                    res = res.substring(0, res.length() - str.length());
                    temp[row][col + 1] = s;
                }
            }

        }


        return false;
    }


}
