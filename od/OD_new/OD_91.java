package com.od.OD.OD130;

import java.util.Scanner;
/*
*机房布局 100%
求至少需要多少电箱
输入MIIM M表示机柜 I表间隔 只有I的地方才能放电箱
输出2
 * 思路：遍历字符串，遇上M，先看后面是否为I
 * 如果是I，安装电箱，而且I后面接着是M，可以共享，index+2，如：MIM
 * 如果不是，就看前面是否为I
 * 是I，就在前面安装电箱 如：IM
 * 如果也不是，返回-1，表示无解 如：M
* */
public class OD_91 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        int res = 0;
        for(int i=0; i<string.length(); i++){

            char c = string.charAt(i);

            if(c == 'M'){
                if( i+1 < string.length() && string.charAt(i+1) == 'I'){
                    res ++;
                    i += 2;
                }else if(i-1 >= 0 && string.charAt(i-1) == 'I'){
                    res ++;
                }else {
                    res = -1;   //前后都没有空间则为-1，且退出循环
                    break;
                }
            }

        }

        System.out.println(res);
    }

}