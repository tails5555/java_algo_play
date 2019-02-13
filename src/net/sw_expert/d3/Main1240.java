package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW Expert D3 단순 Yee진 암호코드 문제 풀이
public class Main1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String password = "";
            for(int l = 0; l < N; l++){
                String tmp = br.readLine();
                if(tmp.contains("1"))
                    password = tmp;
            }
            int lastIdx = password.lastIndexOf("1");
            password = password.substring(lastIdx - 55, lastIdx + 1);
            int[] a = new int[8];
            for(int l = 0; l < 8; l++){
                switch(password.substring(l * 7, (l + 1) * 7)){
                    case "0001101" :
                        a[l] = 0;
                        break;
                    case "0011001" :
                        a[l] = 1;
                        break;
                    case "0010011" :
                        a[l] = 2;
                        break;
                    case "0111101" :
                        a[l] = 3;
                        break;
                    case "0100011" :
                        a[l] = 4;
                        break;
                    case "0110001" :
                        a[l] = 5;
                        break;
                    case "0101111" :
                        a[l] = 6;
                        break;
                    case "0111011" :
                        a[l] = 7;
                        break;
                    case "0110111" :
                        a[l] = 8;
                        break;
                    case "0001011" :
                        a[l] = 9;
                        break;
                }
            }
            int checkSum = (a[0] + a[2] + a[4] + a[6]) * 3 + (a[1] + a[3] + a[5]) + a[7];
            System.out.printf("#%d %d\n", k+1, checkSum % 10 == 0 ? Arrays.stream(a).reduce(0, (v1, v2) -> v1 + v2) : 0);
        }
    }
}
