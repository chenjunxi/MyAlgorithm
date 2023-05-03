package com.od.OD.OD130;

import java.util.*;
/*
硬件销售方案

* */
public class OD_70_new {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount=Integer.valueOf(in.nextLine());
        String input=in.nextLine().replaceAll("\\s","");
        input=input.substring(1,input.length()-1);
        String[] arr=input.split(",");
        int[] prices=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            prices[i]=Integer.valueOf(arr[i]);
        }
        Arrays.sort(prices);
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(prices,amount,st,ans,0);
        System.out.println(ans);
    }

    public static void dfs(int[] prices,int amout,Stack<Integer> st,List<List<Integer>> ans,int index){
        if(amout==0){
            ans.add(new ArrayList<Integer>(st));
            return;
        }
        if(amout<prices[0]) return;

        for(int i=index;i<prices.length;i++){
            int price=prices[i];
            st.push(price);
            dfs(prices,amout-price,st,ans,i);
            st.pop();
        }
    }
}