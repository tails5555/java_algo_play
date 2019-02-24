package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Baekjoon 4963 번 섬의 개수 문제 풀이
public class Main4963 {
    static final int[] dr = { 0, 1, 1,  1,  0, -1, -1, -1 };
    static final int[] dc = { 1, 1, 0, -1, -1, -1,  0,  1 };
    static int R, C;

    static boolean hasInside(int r, int c){
        return (r >= 0) && (r < R) && (c >= 0) && (c < C);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if(C == 0 && R == 0) break;
            boolean[][] map = new boolean[R][C];
            for(int k = 0; k < R; k++){
                st = new StringTokenizer(br.readLine(), " ");
                int idx = 0;
                while(st.hasMoreTokens()){
                    map[k][idx++] = st.nextToken().equals("1");
                }
            }

            int count = 0;
            for(int k = 0; k < R; k++){
                for(int l = 0; l < C; l++){
                    if(map[k][l]) {
                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[] { k, l });
                        map[k][l] = false;
                        while(!stack.isEmpty()){
                            int[] tmp = stack.pop();
                            for(int m = 0; m < dr.length; m++){
                                int tr = tmp[0] + dr[m];
                                int tc = tmp[1] + dc[m];
                                if(hasInside(tr, tc)){
                                    if(map[tr][tc]){
                                        map[tr][tc] = false;
                                        stack.push(new int[] { tr, tc });
                                    }
                                }
                            }
                        }

                        count += 1;
                    }
                }
            }

            bw.append(String.format("%d\n", count));
        }
        bw.flush();
    }
}
