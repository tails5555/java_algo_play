package net.hackerrank.string;

// Hacker Rank String 문제
// Make Anagram 문제
public class Example01 {
    static int makeAnagram(String a, String b) {
        char[] tmp_a = a.toCharArray();
        int[] cnt_a = new int[26];

        for(int k=0;k<tmp_a.length;k++){
            cnt_a[tmp_a[k] - 'a'] += 1;
        }

        char[] tmp_b = b.toCharArray();
        int[] cnt_b = new int[26];

        for(int k=0;k<tmp_b.length;k++){
            cnt_b[tmp_b[k] - 'a'] += 1;
        }

        int cnt = 0;
        for(int k=0;k<26;k++){
            if(cnt_a[k] != cnt_b[k]) {
                cnt += Math.abs(cnt_a[k] - cnt_b[k]);
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(makeAnagram("cde", "dcf"));
        System.out.println(makeAnagram("abc", "cde"));
    }
}
