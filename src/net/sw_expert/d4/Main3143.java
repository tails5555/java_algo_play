package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 가장 빠른 문자열 타Yee핑 문제 풀이
public class Main3143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            String resource = st.nextToken();
            String target = st.nextToken();

            int count = 0;
            while(resource.indexOf(target) != -1){
                resource = resource.replaceFirst(target, "");
                count += 1;
            }

            System.out.printf("#%d %d\n", k+1, count + resource.length());
        }
    }
}
