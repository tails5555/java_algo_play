package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Baekjoon KOI 2007 초등부 지역본선 3번 경비원 문제 풀이
public class Main2564 {
    static BufferedReader br;
    static StringTokenizer st;

    static int R, C;
    static List<int[]> store_pos;
    static int[] my_pos;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        store_pos = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int dir = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());

            switch(dir){
                case 1 :
                    store_pos.add(new int[] { 0, cur });
                    break;
                case 2 :
                    store_pos.add(new int[] { R, cur });
                    break;
                case 3 :
                    store_pos.add(new int[] { cur, 0 });
                    break;
                case 4 :
                    store_pos.add(new int[] { cur, C });
                    break;
            }
        }

        my_pos = new int[2];
        st = new StringTokenizer(br.readLine(), " ");
        int dir = Integer.parseInt(st.nextToken());
        int cur = Integer.parseInt(st.nextToken());
        switch(dir){
            case 1 :
                my_pos = new int[] { 0, cur };
                break;
            case 2 :
                my_pos = new int[] { R, cur };
                break;
            case 3 :
                my_pos = new int[] { cur, 0 };
                break;
            case 4 :
                my_pos = new int[] { cur, C };
                break;
        }
    }

    static void solution(){
        int res = 0;
        for(int k = 0; k < store_pos.size(); k++){
            int[] store = store_pos.get(k);
            if((store[0] == 0 && my_pos[0] == R) || (store[0] == R && my_pos[0] == 0)){
                res += (R + Math.min(my_pos[1] + store[1], (C - my_pos[1]) + (C - store[1])));
            } else if((store[1] == 0 && my_pos[1] == C) || (store[1] == C && my_pos[1] == 0)) {
                res += (C + Math.min(my_pos[0] + store[0], (R - my_pos[0]) + (R - store[0])));
            } else {
                res += ((Math.abs(store[0] - my_pos[0]) + Math.abs(store[1] - my_pos[1])));
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
