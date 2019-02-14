package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 퍼펙트 셔플 문제 풀이
public class Main3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            String[] tmp = new String[N];
            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(idx < N){
                tmp[idx++] = st.nextToken();
            }
            int first = 0;
            int second = (int) Math.ceil(tmp.length / 2.0);
            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < tmp.length; l++){
                if(l % 2 == 0)
                    sb.append(String.format("%s ", tmp[first++]));
                else
                    sb.append(String.format("%s ", tmp[second++]));
            }
            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
