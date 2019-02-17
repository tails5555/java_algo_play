package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SW Expert D3 승률 비교하기 문제 풀이
public class Main3975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int alice_win = Integer.parseInt(st.nextToken());
            int alice_comp = Integer.parseInt(st.nextToken());

            int bob_win = Integer.parseInt(st.nextToken());
            int bob_comp = Integer.parseInt(st.nextToken());

            double alice_per = (double) alice_win / alice_comp;
            double bob_per = (double) bob_win / bob_comp;

            bw.append(String.format("#%d %s\n", k+1, alice_per == bob_per ? "DRAW" : alice_per > bob_per ? "ALICE" : "BOB"));
        }
        bw.flush();
    }
}
