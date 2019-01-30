package net.hackerrank.recursion;

// Hacker Rank 재귀 함수 응용 문제
// Davis' Staircase 문제
public class Example02 {
    static int[] dp = new int[37];
    static int stepPerms(int n) {
        if(dp[n] != 0) return dp[n];
        if(n <= 1) {
            dp[n] = 1;
            return dp[n];
        }

        long res = 0;
        for(int k = 1; k <= Math.min(n, 3); k++){
            res += stepPerms(n - k) % 10000000007L;
        }

        dp[n] = (int) res;
        return (int) res;
    }

    public static void main(String[] args){
        System.out.println(stepPerms(1));
        System.out.println(stepPerms(2));
        System.out.println(stepPerms(3));
        System.out.println(stepPerms(4));
        System.out.println(stepPerms(5));
        System.out.println(stepPerms(6));
        System.out.println(stepPerms(7));
    }
}
