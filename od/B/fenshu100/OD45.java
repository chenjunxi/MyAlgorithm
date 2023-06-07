package com.od.B.fenshu100;

import java.util.Scanner;

/*
* 代码编辑器
*
* 思路：逻辑题，每个指令案例都要测试好
* */



public class OD45 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        sc.nextLine();
        String code = sc.nextLine();
        //光标
        int index = 0;
        int X, len;

        for (int i = 0; i < K; i++) {

            String[] actions = sc.nextLine().split(" ");
            //操作
            String action = actions[0];
            //操作内容
            String word = actions[1];

            switch (action) {
                case "FORWARD":
                    X = Integer.valueOf(word);
                    //光标最远不能超过编码长度
                    index = Math.min(index + X, code.length());
                    break;
                case "BACKWARD":
                    X = Integer.valueOf(word);
                    //光变最前不能超过0
                    index = Math.max(index - X, 0);
                    break;
                case "SEARCH-FORWARD":
                    index = searchForward(index, word, code);
                    break;
                case "SEARCH-BACKWARD":
                    index = searchBackward(index, word, code);
                    break;
                case "INSERT":
                    len = word.length();
                    code = code.substring(0, index) + word + code.substring(index);
                    index += len;
                    break;
                case "REPLACE":
                    len = word.length();
                    if (index + len > code.length()) {
                        //替换超过了代码长度，则后面的不要了
                        code = code.substring(0, index) + word;
                    } else {
                        code = code.substring(0, index) + word + code.substring(index + len);
                    }
                    //光标移到word尾
                    index += len;
                    break;
                case "DELETE":
                    X = Integer.valueOf(word);
                    if (index + X > code.length()) {
                        //删除超过代码长度，则后面的不要了
                        code = code.substring(0, index);
                    } else {
                        code = code.substring(0, index) + code.substring(index + X);
                    }
            }
        }

        System.out.println(code);
    }

    public static int searchForward(int index, String word, String code) {
        //查找的字符长度
        int len = word.length();
        for (int i = index; i >= len; i--) {
            //根据查找字符的长度进行字符串截取
            String string = code.substring(i - len, i);
            if (word.equals(string)) {
                //找到第一个符合的字符返回其起始位置
                return i - len;
            }
        }

        return index;
    }

    public static int searchBackward(int index, String word, String code) {
        //查找的字符长度
        int len = word.length();
        for (int i = index; i <= code.length() - len; i++) {
            //根据查找字符的长度进行字符串截取
            String string = code.substring(i, i + len);
            if (word.equals(string)) {
                //找到第一个符合的字符返回其起始位置
                return i;
            }
        }

        return index;
    }
}
