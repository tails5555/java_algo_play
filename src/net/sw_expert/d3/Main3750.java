package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// SW Expert D3 Digit Sum 문제 풀이
public class Main3750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int k = 0; k < N; k++){
            long num = Long.parseLong(br.readLine());

            String tmp = Long.toString(num);
            while(tmp.length() > 1) {
                int sum = 0;
                for(int l = 0; l < tmp.length(); l++){
                    sum += (tmp.charAt(l) - '0');
                }
                tmp = Integer.toString(sum);
            }

            bw.write(String.format("#%d %s\n", k + 1, tmp));
        }

        bw.flush();
    }
}
