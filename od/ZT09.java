package com.od.exam;

import java.util.Scanner;

public class ZT09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] arr0 = sc.nextLine().split(" ");
        int[] arr = new int[arr0.length];
        for (int i = 0; i < arr0.length; i++) {
            arr[i] = Integer.parseInt(arr0[i]);
        }
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < arr.length){
            if (left == right){
                right++;
            }
            if (checkAvMin(arr,left,right,num)){//需要查找到最大的数组？
                while (right <arr.length && checkAvMin(arr,left,right,num)){
                    right++;
                }
                right--;
                sb.append(left).append("-").append(right).append(" ");
                right++;
            }else {
                left++;
            }
        }
        System.out.println(sb);

    }

    //给出数组，求平均值是否小于等于某个期望值
    private static boolean checkAvMin(int[] arr,int start,int end,int target){
        double total = 0;
        for (int i = start; i < end+1; i++) {
            total += arr[i];
        }
        double res = total/(end - start +1);
        return res <= target;
    }
}
