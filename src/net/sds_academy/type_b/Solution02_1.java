package net.sds_academy.type_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution02_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N, P, M;
        long[] result = new long[T+1];
        for(int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] nums = new int[N];
            st = new StringTokenizer(br.readLine(), " ");

            for(int l=0;l<nums.length;l++){
                nums[l] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums, 1, nums.length);

            for(int l=1;l<=M;l++){
                nums[l] = (- 1) * nums[l];
            }
            for(int l=0;l<nums.length;l++){
                result[k] += nums[l];
            }
        }

        for(int k=1;k<=T;k++){
            System.out.printf("#%d %d\n", k, result[k]);
        }
    }
}
