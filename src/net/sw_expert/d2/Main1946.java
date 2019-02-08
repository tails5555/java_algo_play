package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 간단한 압축 풀기 문제 풀이
public class Main1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            int tcnt = 0;
            for(int l=0;l<N;l++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String alp = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());
                for(int m=0;m<cnt;m++){
                    sb.append(alp);
                    tcnt += 1;
                    if(tcnt % 10 == 0)
                        sb.append("\n");
                }
            }
            System.out.printf("#%d\n", k+1);
            System.out.println(sb.toString());
        }
    }
}
