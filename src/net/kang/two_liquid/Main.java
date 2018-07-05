package net.kang.two_liquid;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long[] liquid = new long[N];
        for(int k=0;k<N;k++)
            liquid[k] = s.nextInt();
        Arrays.sort(liquid);

        int start = 0;
        int end = N - 1;
        long sum = Long.MAX_VALUE;
        int a=start, b=end;
        while(start < end){
            long curSum = liquid[start] + liquid[end];
            if(sum > Math.abs(curSum)){
                sum = Math.abs(curSum);
                a=start;
                b=end;
            }
            if(Math.abs(curSum) > Math.abs(liquid[start+1] + liquid[end])){
                start++;
            }else if(Math.abs(curSum) > Math.abs(liquid[start] + liquid[end-1])){
                end--;
            }else{
                end--;
            }
        }

        System.out.printf("%d %d\n", liquid[a], liquid[b]);
    }
}
