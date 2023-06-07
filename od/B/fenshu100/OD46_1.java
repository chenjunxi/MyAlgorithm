package com.od.B.fenshu100;

import java.util.Scanner;

/*
* LTV解码
重点理解小端序定义
    public static int getLength(String str1, String str2) {
        //因为是小端序，所以第二个字符串排在前面，第一个字符串排在后面
        String string = str2 + str1;
        return Integer.valueOf(string, 16);

    }

31
32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
输出： 32 33
解析：32是tag，后面固定2位都是长度：01和00，01和00算出对应16进制是1，说明value值有1位，也就是AE
tag固定是1位，长度固定是2位，value位数取决于长度的16进制值。
所以全部解析如：
32 01 00 AE
90 02 00 01 02
30 03 00 AB 32 31
31 02 00 32 33
33 01 00 CC
思路：循环定位,以tag的位置做参考
* */
public class OD46_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String tag = sc.nextLine();
        String[] code = sc.nextLine().split(" ");

        for (int i = 0; i < code.length; i++) {
            String s = code[i];
            int length = getLength(code[i + 1], code[i + 2]);

            if (s.equals(tag)) {
                String res = "";
                for (int j = i + 3; j < i + 3 + length; j++) {
                    res += code[j] + " ";
                }
                System.out.println(res.substring(0, res.length() - 1));
                break;
            }

            i += 2 + length;
        }
    }

    private static void demo(String tag, String[] code) {
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
