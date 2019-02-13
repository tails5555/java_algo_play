package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            while(st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                sum += (tmp < 40) ? 40 : tmp;
            }
            System.out.printf("#%d %d\n", k+1, sum / 5);
        }
    }
}
