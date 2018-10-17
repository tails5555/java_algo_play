package net.kang.two_liquid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] liquid = new long[N];
        int k=0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            liquid[k++] = Integer.parseInt(st.nextToken());
        }

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
