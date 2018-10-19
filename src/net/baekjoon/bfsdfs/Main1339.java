package net.baekjoon.bfsdfs;

import java.util.Arrays;
import java.util.Scanner;

// 백준 1339번 문제 풀이 완료
public class Main1339 {
    static int[] alphabet = new int[26];
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int k=0;k<N;k++){
            String tmp = s.next();
            char[] chars = tmp.toCharArray();
            for(int l=0;l<chars.length;l++){
                alphabet[chars[l]-'A']+=(int)Math.pow(10, chars.length-1-l);
            }
        }
        Arrays.sort(alphabet);

        int ans = 0;
        int value = 9;

        for(int k=alphabet.length-1;k>=0;k--){
            if(value!=0)
                ans += value-- * alphabet[k];
            else break;
        }
        System.out.println(ans);
    }
}
