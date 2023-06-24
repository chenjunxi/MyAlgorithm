package com.leecode;

/*
*
* 旋转二维矩形
* */
public class leecode48_2 {
    public static void main(String[] args) {

    }

    //对角线反转之后左右翻转
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //先按照对角线翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //每一行再翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
