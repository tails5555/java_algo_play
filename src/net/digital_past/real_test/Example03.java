package net.digital_past.real_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Example03 {
    static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };

    static class Pos{
        int x;
        int y;
        int cnt;
        public Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static boolean hasAllTrue(boolean[][] chess){
        for(int k=0;k<chess.length;k++){
            for(int l=0;l<chess[k].length;l++){
                if(!chess[k][l]) return false;
            }
        }
        return true;
    }
    static boolean isInside(int px, int py, int lx, int ly){
        return (px >= 0 && px <= lx - 1) && (py >= 0 && py <= ly - 1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        boolean[][] chess = new boolean[width][height];
        chess[0][0] = true;
        Queue<Pos> posQueue = new LinkedList<>();
        posQueue.add(new Pos(0, 0, 0));
        int count = 0;
        while(!posQueue.isEmpty()){
            Pos pos = posQueue.poll();
            for(int k=0;k<8;k++){
                int tmpX = pos.x + dx[k];
                int tmpY = pos.y + dy[k];
                if(isInside(tmpX, tmpY, width, height)){
                    if(!chess[tmpX][tmpY]){
                        chess[tmpX][tmpY] = true;
                        posQueue.add(new Pos(tmpX, tmpY, pos.cnt+1));
                    }
                }
            }
            count = pos.cnt;
        }
        System.out.printf("%s%d", hasAllTrue(chess) ? "T" : "F", count);
    }
}
