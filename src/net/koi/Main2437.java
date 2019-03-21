package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 2437 번 KOI 2011 초등부 저울 문제 풀이
public class Main2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()){
            weight[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);
        if(weight[0] != 1){
            System.out.println(1);
        } else {
            int sum = 1;
            for(int k=1;k<N;k++){
                if(weight[k] > sum + 1) break;
                sum += weight[k];
            }
            System.out.println(sum + 1);
        }
    }
}
