package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// SW Expert D3 웬그막 주현의 먹을 거 바꾸기 문제 풀이
public class Main5789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[Integer.parseInt(st.nextToken())];
            int query = Integer.parseInt(st.nextToken());

            for(int l = 1; l <= query; l++){
                st = new StringTokenizer(br.readLine(), " ");
                Arrays.fill(arr, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), l);
            }

            String res = Arrays.stream(arr).mapToObj(v -> Integer.toString(v)).collect(Collectors.joining(" "));
            System.out.printf("#%d %s\n", k+1, res);
        }
    }
}
