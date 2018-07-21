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
        int[] result = new int[T+1];
        for(int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int l=0;l<N;l++){
                nums[l] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums, 1, nums.length);
            int maxinum = nums[0];
            for(int l=1;l<N;l++){
                if(l <= M)
                    maxinum = maxinum - nums[l];
                else
                    maxinum = maxinum + nums[l];
            }
            result[k] = maxinum;
        }

        for(int k=1;k<=T;k++){
            System.out.printf("#%d %d\n", k, result[k]);
        }
    }
}
