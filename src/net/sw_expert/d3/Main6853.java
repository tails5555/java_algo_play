package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 직사각형과 점 문제 풀이
public class Main6853 {
    static boolean isCompleteInside(int t, int t1, int t2) {
        return (t > t1) && (t < t2);
    }

    static boolean isInside(int t, int t1, int t2) {
        return (t >= t1) && (t <= t2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int outside = 0;
            int edgeInside = 0;
            int compInside = 0;

            int N = Integer.parseInt(br.readLine());
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int x3 = Integer.parseInt(st.nextToken());
                int y3 = Integer.parseInt(st.nextToken());

                if(isInside(x3, x1, x2) && isInside(y3, y1, y2)) {
                    if(isCompleteInside(x3, x1, x2) && isCompleteInside(y3, y1, y2)) {
                        compInside += 1;
                    } else {
                        edgeInside += 1;
                    }
                } else {
                    outside += 1;
                }
            }

            System.out.printf("#%d %d %d %d\n", k+1, compInside, edgeInside, outside);
        }
    }
}
