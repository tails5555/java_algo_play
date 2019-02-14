package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// SW Expert D3 늘어지는 소리 만들기 문제 풀이
public class Main4676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < T; k++) {
            char[] word = br.readLine().toCharArray();
            int H = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;

            Map<Integer, String> map = new HashMap<>();
            while(idx < H){
                int tmpIdx = Integer.parseInt(st.nextToken());
                String tmpValue = map.getOrDefault(tmpIdx, "");
                map.put(tmpIdx, tmpValue + "-");
                idx += 1;
            }

            StringBuilder sb = new StringBuilder();

            for(int l = 0; l <= word.length; l++){
                String tmp = map.get(l);
                if(tmp != null)
                    sb.append(tmp);

                if(l < word.length)
                    sb.append(word[l]);
            }

            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
