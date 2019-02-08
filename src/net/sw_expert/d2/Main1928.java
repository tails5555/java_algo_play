package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D2 Base64 Decoder 문제
public class Main1928 {
    public static int getBase64Bits(char tmp){
        if(Character.isAlphabetic(tmp)) {
            if(tmp >= 'a' && tmp <= 'z') return tmp - 'a' + 26;
            else return tmp - 'A';
        } else if(Character.isDigit(tmp)) {
            return tmp - '0' + 52;
        }
        else if(tmp == '+') return 62;
        else if(tmp == '-') return 63;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            char[] str = br.readLine().toCharArray();
            char[] ans = new char[str.length / 4 * 3];
            int idx = 0;
            for(int l = 0; l < str.length / 4; l++){
                int val = getBase64Bits(str[l * 4]);
                for(int m = 1; m < 4; m++){
                    val <<= 6;
                    val += getBase64Bits(str[l * 4 + m]);
                }
                Stack<Character> stack = new Stack<>();
                for(int m = 0; m <= 2; m++) {
                    int tmp = val % 128;
                    stack.push((char) tmp);
                    val >>= 8;
                }
                while(!stack.isEmpty()){
                    ans[idx++] = stack.pop();
                }
            }
            System.out.printf("#%d %s\n", k + 1, new String(ans));
        }
    }
}
