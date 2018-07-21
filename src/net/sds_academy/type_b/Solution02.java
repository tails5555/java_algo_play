package net.sds_academy.type_b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution02 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
    static int[] nums;
    static int maxinum, T;
    public static void dfs(int[] nums, int idx, int plus, int minus, int result){
        if(idx == nums.length) {
            if(plus == 0 && minus == 0) {
                maxinum = Math.max(maxinum, result);
                return;
            } else return;
        }
        if(plus > 0 && minus > 0){
            dfs(nums, idx + 1, plus - 1, minus, result + nums[idx]);
            dfs(nums, idx + 1, plus, minus - 1, result - nums[idx]);
        } else if(plus == 0){
            for(int k=idx;k<nums.length;k++){
                result -= nums[k];
            }
            dfs(nums, nums.length, 0, 0, result);
        } else if(minus == 0){
            for(int k=idx;k<nums.length;k++){
                result += nums[k];
            }
            dfs(nums, nums.length, 0, 0, result);
        } else return;
    }
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        int N, P, M;
        for(int k=1;k<=T;k++) {
            maxinum = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            nums = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int l=0;l<N;l++){
                nums[l] = Integer.parseInt(st.nextToken());
            }
            dfs(nums, 1, P, M, nums[0]);
            if(k != T)
                bw.append(String.format("#%d %d\n", k, maxinum));
            else
                bw.append(String.format("#%d %d", k, maxinum));
        }
        bw.flush();
        bw.close();
    }
}
