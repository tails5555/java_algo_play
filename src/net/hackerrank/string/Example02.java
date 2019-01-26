package net.hackerrank.string;

// Hacker Rank String 문제
// Alternating Characters 문제
public class Example02 {
    static int alternatingCharacters(String s) {
        char[] word = s.toCharArray();
        int cnt = 0;
        for(int k = 0; k < word.length - 1; k++){
            if(word[k] == word[k + 1]) cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABAB"));
        System.out.println(alternatingCharacters("BABABA"));
        System.out.println(alternatingCharacters("AAABBB"));
    }
}
