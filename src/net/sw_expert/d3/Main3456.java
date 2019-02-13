package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// SW Expert D3 직사각형 길이 찾기 문제 풀이
// Map 에 대한 응용도를 알아보기 위한 괜찮은 문제로 생각함.
public class Main3456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            Map<Integer, Integer> map = new HashMap<>();
            while(st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                int cnt = map.getOrDefault(tmp, 0);
                map.put(tmp, cnt + 1);
            }

            int ans = 0;
            for(int m : map.keySet()) {
                if(map.get(m) % 2 != 0) {
                    ans = m;
                    break;
                }
            }

            System.out.printf("#%d %d\n", k+1, ans);
        }
    }
}
