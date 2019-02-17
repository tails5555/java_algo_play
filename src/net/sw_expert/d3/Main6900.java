package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D3 종현이의 복권 당첨 문제 풀이
public class Main6900 {
    static boolean patternConfirm(String p, String b){
        char[] tmpP = p.toCharArray();
        char[] tmpB = b.toCharArray();
        boolean confirm = true;
        for(int k = 0; k < tmpP.length; k++){
            if(tmpP[k] != '*'){
                if(tmpP[k] != tmpB[k]) {
                    confirm = false;
                    break;
                }
            }
        }

        return confirm;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Map<String, Integer> map = new HashMap<>();
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            Map<String, Integer> buy = new HashMap<>();
            int award = 0;
            Set<String> patterns = map.keySet();
            for(int l = 0; l < M; l++){
                String ticket = br.readLine();
                if(buy.containsKey(ticket)){
                    award += buy.get(ticket);
                } else {
                    for (String pattern : patterns) {
                        if(patternConfirm(pattern, ticket)) {
                            int price = map.get(pattern);
                            award += price;
                            buy.put(ticket, price);
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, award);
        }
    }
}
