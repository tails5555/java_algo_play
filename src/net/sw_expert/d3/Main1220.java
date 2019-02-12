package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 마그네틱 문제 풀이
// 이는 풀이 참조하였음...
public class Main1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 10; k++){
            String[] map = new String[Integer.parseInt(br.readLine())];
            for(int l = 0; l < map.length; l++)
                map[l] = "";
            StringTokenizer st;
            for(int l = 0; l < map.length; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                int idx = 0;
                while(st.hasMoreTokens()) {
                    map[idx++] += st.nextToken();
                }
            }
            int res = 0;
            for(int l = 0; l < map.length; l++){
                String s = map[l]
                    .replace("0","")
                    .replaceAll("1+","1")
                    .replaceAll("2+","2")
                    .replaceAll("1$","")
                    .replaceAll("^2","");
                res += s.length() / 2;
            }
            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
