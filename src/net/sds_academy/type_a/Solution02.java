package net.sds_academy.type_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution02 {
    public static boolean validate(int N, int m, int n){
        return (m >= 0 && m < N) && (n >= 0 && n < N);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T+1];
        int[][] map;
        int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int N;
        for(int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int l=0;l<N;l++){
                int x = 0;
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    map[l][x++] = Integer.parseInt(st.nextToken());
                }
            }

            for(int m=0;m<N;m++){
                for(int n=0;n<N;n++){
                    Set<Integer> types = new HashSet<Integer>();
                    for(int con=0; con<dy.length; con++){
                        int y = m+dy[con];
                        int x = n+dx[con];
                        if(validate(N, y, x)){
                            if(map[y][x] != 0) types.add(map[y][x]);
                            else{
                                types.add(0);
                                break;
                            }
                        }
                    }
                    if(!types.contains(0) && types.size() >= 3){
                        result[k] = result[k] + 1;
                    }
                }
            }
        }
        for(int k=1;k<=T;k++){
            System.out.printf("#%d %d\n", k, result[k]);
        }
    }
}
