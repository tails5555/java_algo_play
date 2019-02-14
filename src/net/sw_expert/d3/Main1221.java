package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D3 GNS 문제 풀이
public class Main1221 {
    static final Map<String, Integer> lang_to_num = new HashMap<String, Integer>() {
        {
            put("ZRO", 0); put("ONE", 1); put("TWO", 2); put("THR", 3); put("FOR", 4);
            put("FIV", 5); put("SIX", 6); put("SVN", 7); put("EGT", 8); put("NIN", 9);
        }
    };

    static class Code {
        String lang;
        int value;

        public Code(String lang, int value) {
            this.lang = lang;
            this.value = value;
        }

        public String getLang() {
            return this.lang;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            String code = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            PriorityQueue<Code> pq = new PriorityQueue<>(Comparator.comparingInt(Code::getValue));

            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(idx < N){
                String lang = st.nextToken();
                pq.offer(new Code(lang, lang_to_num.get(lang)));
                idx += 1;
            }

            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty()){
                Code c = pq.poll();
                sb.append(String.format("%s ", c.getLang()));
            }
            System.out.println(code);
            System.out.println(sb.toString());
        }
    }
}
