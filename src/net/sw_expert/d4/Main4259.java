package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// SW Expert D4 제곱수의 합 계산하기 문제 풀이
public class Main4259 {
    static BigInteger power(int expo, int base){
        if(expo == 0) return BigInteger.valueOf(1L);
        else return BigInteger.valueOf(base).multiply(power(expo - 1, base));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            BigInteger res = BigInteger.valueOf(0L);
            for(int l = 0; l < N; l++){
                int tmp = Integer.parseInt(st.nextToken());
                res = res.add(power(tmp % 10, tmp / 10));
            }
            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
