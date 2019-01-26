package net.hackerrank.string;

// Hacker Rank String 문제
// Common Child 문제
// DP 는 좀 공부해야 되겠다...ㅜㅜ
public class Example05 {
    static int commonChild(String s1, String s2) {
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();

        int[][] dp = new int[word1.length+1][word2.length+1];
        for(int k=1;k<=word1.length;k++){
            for(int l=1;l<=word2.length;l++){
                if(word1[k-1] == word2[l-1])
                    dp[k][l] = dp[k - 1][l - 1] + 1;
                else
                    dp[k][l] = Math.max(dp[k][l-1], dp[k - 1][l]);
            }
        }

        return dp[word1.length][word1.length];
    }

    public static void main(String[] args){
        System.out.println(commonChild("AA", "BB"));
        System.out.println(commonChild("SHINCHAN", "NOHARAAA")); // 쥔쫘 문제 예제에 나왔음. 본인이 짱구 팬이라서 그런 거일 수 있지만...
        System.out.println(commonChild("ABCDEF", "FBDAMN"));
        System.out.println(commonChild("WOOODIE", "GOCHILD")); // O, I
        System.out.println(commonChild("곰팽이일병", "이경래병장")); // 이, 장
    }
}
