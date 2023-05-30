package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
* 最大连续文件之和 / 区块链文件转储系统
*求最大连续文件大小之和 但是不能超过指定容量
1000
100 300 500 400 400 150 100
950
[400 400 150]

滑窗思维
* */
//

class OD_84 {
    public static void main(String[] args) {
        int res = 0;
        Scanner in = new Scanner(System.in);
        int sataSize = in.nextInt();
        List<Integer> fileSizeList = new ArrayList<>();
        while (in.hasNext()) {
            fileSizeList.add(in.nextInt());
        }
        int sum = 0;
        int fast = 0, slow = 0;
        while (fast < fileSizeList.size()) {
            sum += fileSizeList.get(fast);
            while (sum > sataSize) {
                sum -= fileSizeList.get(slow);
                slow++;
            }
            if (sum <= sataSize && sum > res) {
                res = sum;
            }
            fast++;
        }
        System.out.println(res);
    }

}