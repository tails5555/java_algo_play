package net.sw_expert;

import java.util.Scanner;

// SW Expert 1926. 간단한 3 6 9 게임
public class Main1926 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int k=1;k<=N;k++){
            String num = Integer.toString(k).replaceAll("(3|6|9)", "-");
            if(num.matches(".*-+.*")){
                num = num.replaceAll("(0|1|2|4|5|7|8)", "");
            }
            sb.append(String.format("%s ", num));
        }
        System.out.println(sb.toString());
    }
}
