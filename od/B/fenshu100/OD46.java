package com.od.B.fenshu100;

import java.util.Scanner;

public class OD46 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String tag = sc.nextLine();
        String[] code = sc.nextLine().split(" ");

        int index = 0;
        //value的末尾位置
        int end = code.length - 1;
        //value的长度
        int len;
        //是否为匹配的tag
        boolean isMatch = false;
        String res = "";
        while (index <= end) {

            if (isMatch) {
                res += code[index] + " ";
            } else {
                //value的长度，因为长度是2个字节，所以将后面的2个字符串传过去
                len = getLength(code[index + 1], code[index + 2]);
                if (code[index].equals(tag)) {
                    //找到符合的tag，则进行value输出
                    index += 2;
                    //表示满足tag
                    isMatch = true;
                    end = index + len;
                } else {
                    //下一个tag的位置
                    index += 2 + len;
                }
            }

            index++;
        }

        System.out.println(res.substring(0, res.length() - 1));
    }

    public static int getLength(String str1, String str2) {
        //因为是小端序，所以第二个字符串排在前面，第一个字符串排在后面
        String string = str2 + str1;
        return Integer.valueOf(string, 16);

    }
}
