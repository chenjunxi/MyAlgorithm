package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
*新词挖掘
*
* */
public class OD_85{

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String stra = sc.nextLine();
        String strb = sc.nextLine();
        if(stra.length() < strb.length()){
            System.out.println(0);
            return ;
        }
        int count = 0;
        char[] strbc = strb.toCharArray();
        Arrays.sort(strbc);
        int left = 0;
        int right = strb.length()-1;
        while(right < stra.length()){
            String str = stra.substring(left,right+1);
            char[] strba = str.toCharArray();
            Arrays.sort(strba);
            if(check(strba,strbc)){
                count++;
            }
            left++;
            right++;
        }
        System.out.println(count);
    }
    public static boolean check(char[] a,char[] b){
        for(int i=0;i<a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}