package net.baekjoon.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// Baekjoon 5568 번 카드 놓기 문제 풀Yee
public class Main5568 {
    static int[] card;
    static int N;
    static int K;
    static Set<Integer> nums = new HashSet<>();
    static boolean[] used;

    public static boolean confirm() {
        int cnt = 0;
        for(int k=0;k<N;k++){
            if(used[k]) cnt++;
        }
        return cnt == K;
    }

    public static void backtracking(String tmp) {
        if(confirm()) {
            nums.add(Integer.parseInt(tmp));
            return;
        }
        for(int k=0;k<N;k++) {
            if(!used[k]) {
                used[k] = true;
                backtracking(tmp + card[k]);
                used[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        card = new int[N];
        used = new boolean[N];
        for(int k=0;k<N;k++){
            card[k] = Integer.parseInt(br.readLine());
        }

        backtracking("");

        System.out.println(nums.size());
    }
}
