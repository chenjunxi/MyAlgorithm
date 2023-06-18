package com.leecode;

/*
*
* 递增的三元子序列
*
在数组中遍历第三个数，希望这个数能满足，three>two>one
[2,5,1,6]

one two初始值为
遍历three

分三种情况：
three<one 更新one=three
one<three<two two=three
three>two true
* */
public class leecode334_2 {
    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 6};
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int three : nums) {

            if (three > two) {
                System.out.println(true);
                break;
            }

            if (three < one) {
                one = three;
            } else if (three < two && three > one) {
                two = three;
            }
        }

    }
}
