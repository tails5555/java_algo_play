package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// SW Expert D3 민국이의 카드 카운팅 문제 풀이
public class Main4047 {
    static final Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('S', 0); put('D', 1); put('H', 2); put('C', 3);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            boolean[][] checked = new boolean[4][14];
            char[] tmp = br.readLine().toCharArray();
            boolean validated = true;
            if(tmp.length > 52 * 3) {
                validated = false;
            } else {
                for(int l = 0; l < tmp.length / 3; l++){
                    int start = l * 3;
                    int team = map.get(tmp[start]);
                    int no = Integer.parseInt(new String(new char[] { tmp[start + 1], tmp[start + 2] }));
                    if(!checked[team][no]) {
                        checked[team][no] = true;
                    } else {
                        validated = false;
                        break;
                    }
                }
            }

            if(!validated)
                System.out.printf("#%d ERROR\n", k+1);
            else {
                StringBuilder sb = new StringBuilder();
                for(int m = 0; m <= 3; m++) {
                    int cnt = 0;
                    for (int l = 1; l <= 13; l++) {
                        if(!checked[m][l]) cnt += 1;
                    }
                    sb.append(String.format("%d ", cnt));
                }
                System.out.printf("#%d %s\n", k+1, sb.toString());
            }
        }
    }
}
