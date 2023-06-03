package com.od.B.fenshu200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/*
* 报文压缩
3[m2[c]]
mccmccmcc

数字的截取范围：数字到[
字母截取范围：字母到数字或字母到]
* */
public class OD04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        StringBuffer res = new StringBuffer();  //处理前的字母串
        String numStr = "";  //处理多位数
        Deque<Integer> num = new ArrayDeque<>();    //数字队列
        Deque<StringBuffer> zimu = new ArrayDeque<>();  //放置处理后的字母串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (res.length() != 0) {    //数字前的字母暂不处理
                    zimu.push(res);
                    res = new StringBuffer();
                }
                numStr += c;
            } else if (c == '[') {
                num.push(Integer.parseInt(numStr));  //数字放入数字队列
                numStr = "";
            } else if (c == ']') {
                int n = num.pop();  //碰到“]”，就需要取出最上面的数字进行解压
                if (res.length() != 0) {
                    zimu.push(res);
                    res = new StringBuffer();
                }
                StringBuffer temp = zimu.pop(); //取出最上面的字母
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    sb.append(temp);    //对字母进行解压
                }
                if (zimu.isEmpty()) {
                    zimu.push(sb);
                } else {
                    zimu.push(zimu.pop().append(sb));   //后面处理过的字符会跟最上面的字符一起被处理
                }
            } else {
                res.append(c);
            }
        }
        System.out.println(zimu);
    }
}
