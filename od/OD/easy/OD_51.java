package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*寻找关键钥匙
*
* */
public class OD_51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String key = in.nextLine();
            String s = in.nextLine();
            String[] arr = s.split(" ");

            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                List<Character> list = new ArrayList<>();
                for (int j = 0; j < arr[i].length(); j++) {
                    char c = arr[i].charAt(j);
                    if (c >= 'a' && c <= 'z')
                        list.add(c);
                    if (c >= 'A' && c <= 'Z')
                        list.add((char) (c - 'A' + 'a'));
                }
                list = list.stream().sorted().collect(Collectors.toList());
                StringBuffer sb = new StringBuffer();
                list.stream().forEach(c -> sb.append(c));
                if (sb.toString().equals(key)) index = i + 1;
            }
            System.out.println(index);
        }
    }
}
