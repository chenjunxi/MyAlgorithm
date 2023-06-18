package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 三数之和
 *
 * for循环加双指针
 * */
public class leecode0015 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] > 0) return result;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }

        return result;
    }
}
