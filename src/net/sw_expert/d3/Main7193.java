package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 승현이의 수학공부 문제 풀이
// N^k % (N - 1) = 1
// 수학적인 요소를 조금 알아두면 쉽게 풀 수 있는 문제
// 10^2 * 2 + 10^1 * 3 + 10^0 * 9 => 2 + 3 + 9 = 14 => 5
public class Main7193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            String X = st.nextToken();

            int mod = 0;
            for(char c : X.toCharArray()){
                mod += (c - '0') % (N - 1);
            }

            System.out.printf("#%d %d\n", k + 1, mod % (N - 1));
        }
    }
}
