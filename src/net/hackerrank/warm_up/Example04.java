package net.hackerrank.warm_up;

// Hacker Rank Warm Up 문제
// Repeated String 문제
// 반복되는 문자열의 수에서 a의 개수를 찾아라
public class Example04 {
    static long repeatedString(String s, long n) {
        long[] mod_a_cnt = new long[s.length() + 1];
        char[] alps = s.toCharArray();
        for(int k = 1; k <= alps.length; k++){
            mod_a_cnt[k] = Math.max(mod_a_cnt[k], mod_a_cnt[k - 1]);
            if(alps[k - 1] == 'a') {
                mod_a_cnt[k] += 1L;
            }
        }

        if(n % alps.length == 0){
            return mod_a_cnt[alps.length] * (n / alps.length);
        } else {
            return mod_a_cnt[alps.length] * (n / alps.length) + mod_a_cnt[(int)( n % alps.length )];
        }
    }

    public static void main(String[] args){
        System.out.println(repeatedString("abcac", 10L));
        System.out.println(repeatedString("aba", 10L));
        System.out.println(repeatedString("a", 1000000000000L));
    }
}
